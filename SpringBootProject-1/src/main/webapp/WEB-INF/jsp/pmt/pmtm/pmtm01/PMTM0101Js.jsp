<%@page import="com.pmt.pcommon.model.RowStatus"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="NEW" value="<%=RowStatus.NEW%>"/>
<c:set var="NEW_MODIFY" value="<%=RowStatus.NEW_MODIFY%>"/>
<c:set var="MODIFY" value="<%=RowStatus.MODIFY%>"/>
<c:set var="DELETE" value="<%=RowStatus.DELETE%>"/>
<c:set var="NOTMODIFY" value="<%=RowStatus.NOTMODIFY%>"/>

<html>
<head>
 
<script type="text/javascript" src="/SpringBootProject-1/js/jquery.min.js"></script>
<script type="text/javascript" src="/SpringBootProject-1/js/jqwidgets/jqx-all.js"></script>
 
<link rel="stylesheet" href="/SpringBootProject-1/js/jqwidgets/styles/jqx.base.css" type="text/css" />
<link rel="stylesheet" href="/SpringBootProject-1/ui-common/css/custom.css"  type="text/css">
<link rel="stylesheet" href="/SpringBootProject-1/ui-common/css/compiled/theme_styles.css" type="text/css" />
<link rel="stylesheet" href="/SpringBootProject-1/ui-common/css/bootstrap/bootstrap.min.css" type="text/css" />
<script type="text/javascript" src="/SpringBootProject-1/ui-common/js/demo-rtl.js"></script>
<script type="text/javascript" src="/SpringBootProject-1/js/jqwidgets/jqxnotification.js"></script>

	
<style>
.top-margin {
	margin-top: 5px;
}

.label-box {
	height: 25px;
}

.onError {
	color: black;
	background-color: #ff9999;
}


#jqxcalendar {
	position: absolute;
	width: 200px;
	height: 200px;
	background-color: #000;
	filter: alpha(opacity = 50);
	-moz-opacity: 2.0;
	-khtml-opacity: 2.0;
	opacity: 2.0;
	z-index: 10000;
}

#jqxcalendar1 {
	position: absolute;
	width: 200px;
	height: 200px;
	background-color: #000;
	filter: alpha(opacity = 50);
	-moz-opacity: 2.0;
	-khtml-opacity: 2.0;
	opacity: 2.0;
	z-index: 10000;
}

</style> 
 
<script type="text/javascript">
var source={};
var dataAdapter;
var functionUrlPattern = "${pageContext.request.contextPath}/pmtm/pmtm01/pmtm0101/"
var ccViewListData = [];
var statusList = new Array();
var sourceView = {};
var adapterView;
var deletedRow = new Array();

	$(document)
			.ready(
					function() {
						
						var statusSource =
				         {
				      	   datatype: "array",
				      	   datafields: [
				 				{ name: 'cdKey2', map: 'id>cdKey2',type: 'string'},
				              	{ name: 'cdData1',type: 'string'}
				 				],
				 				localdata: statusList
				         };
				         var statusDataAdapter = new $.jqx.dataAdapter(statusSource);
				         
						data = ${PMTM0101Form.resultModel.jsonResult};
						
						source = {
							datatype : 'json',
							datafields : [ {
								name : 'errorCount',
								type : 'int'
							}, {
								name : 'ein',
								type : 'string'
							}, {
								name : 'empName',
								type : 'string'
							}, {
								name : 'empDateOfBirth',
								type : 'string'
							}, {
								name : 'status',
								type : 'string',
								value: 'statusCd',
		                        values: {source: statusDataAdapter.records, value: 'id.cdKey2', name: 'cdData1' }
							}, {
		                         name: 'statusCd',
		                         type: 'string',
		                     }, {
								 name : 'rowStatus',
								 type : 'string'
							 }, {
								 name : 'errorMsg',
								 type : 'string'
							 }, {
								 name : 'errorFieldGrid',
								 type : 'string'
							 }, {
								 name : 'errorFlag',
								 type : 'string'
							 }],
							localdata : data,
						};
			            
			            var columnsrenderer = function(value) {
							return '<div class="gridHeader">' + value + '</div>';
						}
						var renderercolor = function (value) {
							return '<div class="gridHeader">'+value+ '<span class="grid-column-header" style="text-align:center"><b style="color:red;text-align:center">*</b></span></div>';
						};
						   
						var cellsrenderer = function (row, columnfield, value, defaulthtml, columnproperties) {
				            return '<span class="gridInput">' + value + '</span>';
				        } 
						
						var cellbeginedit = function (row, datafield, columntype, value) {
		  					var rowStatus = $("#jqxgridPMTM01").jqxGrid('getcellvalue', row, "rowStatus")
		  	                if (rowStatus == '${MODIFY}' || rowStatus == '${NOTMODIFY}') 
		  	                	return false;
		  	            }
						
		         		var newRowRuleEdit = function (row, datafield, columntype, value) {
	  					var rowStatus = $("#jqxgridPMTM01").jqxGrid('getcellvalue', row, "rowStatus")
	  	                if (rowStatus == '${NEW}' || rowStatus == '${NEW_MODIFY}') 
	  	                	return false;
	  	            	}
		         		
		         		var errorClass = function(row, columnfield, value) {
							if ($("#jqxgridPMTM01").jqxGrid('getcellvalue', row, "errorFlag") == 'true') {
								return 'onError';
							}
							return "black";
						}
		         		
						dataAdapter = new $.jqx.dataAdapter(source);
						var columnCheckBox = null;
						var updatingCheckState = false;
						$("#jqxgridPMTM01").jqxGrid({
							theme : 'ymsli_grid',
							height : 400,
							width : '100%',
							showtoolbar : true,
							pageable : true,
							source : dataAdapter,
							groupable: true,
							autosavestate:false,
					        autoloadstate:false, 
							columnsheight : 32,
							sortable : true,
							editable : true,
							filterable : true,
							columnsresize : true,
							enabletooltips: true,
							handlekeyboardnavigation : function(event) {
								var key = event.charCode ? event.charCode : event.keyCode ? event.keyCode: 0;
								if (key == 86 && event.ctrlKey == true) {
									return true;
								}
							},
							columns : [{
								text : 'Error Count',
								datafield : 'errorCount',
								align : 'center',
								width : '10%',
								required: true,
								editable: false,
								hidden:false,
								cellsrenderer : cellsrenderer, 
								cellclassname: errorClass,
								renderer : columnsrenderer
							}, {
								text : 'Emp Id',
								datafield : 'ein',
								width : '10%',
								align : 'center',
								required: true,
								pinned : false,
								cellclassname: function (row, column, value, defaultHTML) {
		                    	var errorString = $("#jqxgridPMTM01").jqxGrid('getcellvalue', row, "errorFieldGrid");
		                        if(errorString!=null){
		                        	var n = errorString.search("ein");
		                           		if(n>=0){ return 'onError'; }
		                           	 }
		                        }
							}, {
								text : 'Emp Name',
								datafield : 'empName',
								width : '20%',
								align : 'center',
								required: true,
								editable : true,
				                cellvaluechanging: function (row, column, columntype, oldvalue, newvalue) {
	                                 return newvalue.toUpperCase();
				                },
								cellclassname: function (row, column, value, defaultHTML) {
		                    	var errorString = $("#jqxgridPMTM01").jqxGrid('getcellvalue', row, "errorFieldGrid");
		                        if(errorString!=null){
		                        	var n = errorString.search("empName");
		                           	   if(n>=0){ return 'onError'; }
		                           	 }
		                        }
	                       },{
	                    	   
	                    		text : 'Date Of Birth',
								datafield : 'empDateOfBirth',
								width : '30%',
								align : 'center',
								editable: true,
								cellclassname: function (row, column, value, defaultHTML) {
		                    		var errorString = $("#jqxgridPMTM01").jqxGrid('getcellvalue', row, "errorFieldGrid");
		                        	if(errorString!=null){
		                        		var n = errorString.search("empDateOfBirth");
		                           		if(n>=0){ return 'onError'; }
		                           	}
		                        }
	                       }, {
								
							   text: 'Status',
	                           datafield: 'statusCd',
							   displayfield:'status',  
							   width : '40%', 
							   editable: true , 
							   cellsrenderer: cellsrenderer, 
							   align: 'center', 
							   columntype: 'dropdownlist',
							   cellbeginedit: newRowRuleEdit,
	                           cellclassname: function (row, column, value, defaultHTML) {
	                           	   var errorString = $("#jqxgridPMTM01").jqxGrid('getcellvalue', row, "errorFieldGrid");
	                           	   if(errorString!=null){
	                           	 	 var n = errorString.search("status");
		                           	   if(n>=0){
		                           		   return 'onError';
		                           	   }
	                           	 }
	                          }, createeditor: function (row, column, editor) {
                                   editor.jqxDropDownList({ autoDropDownHeight: true , source: statusDataAdapter,displayMember: 'cdData1', valueMember: 'cdKey2' });
                               }
	                          
							}, {
								
								datafield : 'errorMsg',
								text : 'Error Message',
								align : 'center',
								width : '20%',
								hidden:false,
								cellsrenderer : cellsrenderer,
								editable : false,
								renderer : columnsrenderer
							},{
								datafield : 'errorFieldGrid',
								text : 'errorFieldGrid',
								align : 'center',
								width : '10%',
								hidden:true,
								cellsrenderer : cellsrenderer,
								editable : false,
								renderer : columnsrenderer
							},{
		                        datafield: 'rowStatus', 
		                        text: 'Row Status',  
		                        width : '10%', 
		                        align: 'center', 
		                        hidden:true, 
		                        renderer: columnsrenderer
			                   } ,  {
		                        datafield: 'errorFlag', 
		                        text: 'errorFlag',  
		                        width : '10%', 
		                        align: 'center', 
		                        hidden:true, 
		                        renderer: columnsrenderer
			                   }
							]
						});

						$('#jqxgridPMTM01').jqxGrid({
							pagesizeoptions : [ '100', '200', '500' ]
						});
						
						searchStatusAjax();
						
						$("#jqxgridPMTM01").on('cellvaluechanged', function (event) {
							
							   var column = args.datafield;
							   var rowIndex = args.rowindex;
							   var newvalue = args.newvalue;
							   var oldvalue = args.oldvalue;
							   var findvalue = $("#jqxgridPMTM01").jqxGrid('getcellvalue', rowIndex, "rowStatus");
							  
							   var einValue 	= $("#jqxgridPMTM01").jqxGrid('getcellvalue', rowIndex, "ein");
							   var empNameValue = $("#jqxgridPMTM01").jqxGrid('getcellvalue', rowIndex, "empName");
							   var empDobValue  = $("#jqxgridPMTM01").jqxGrid('getcellvalue', rowIndex, "empDateOfBirth");	
							  
							   if(newvalue =='' && newvalue!=oldvalue && findvalue == '${NEW_MODIFY}'){
								   if(checkIfEmpty(einValue) && checkIfEmpty(empNameValue) && checkIfEmpty(empDobValue)){
									   $("#jqxgridPMTM01").jqxGrid('setcellvalue', rowIndex, "rowStatus", '${NEW}');
									   return true;
								   }
							   }
							   
							   if(newvalue!='' && newvalue!=oldvalue && findvalue!= '${DELETE}'){
								   if(findvalue=='${NEW}'){
									   modifyFlag=1;
									   if(!(checkIfEmpty(einValue) && checkIfEmpty(empNameValue) && checkIfEmpty(empDobValue))){
									   		$("#jqxgridPMTM01").jqxGrid('setcellvalue', rowIndex, "rowStatus", '${NEW_MODIFY}');
									   }
									   return true;
								  	} else if(findvalue=='${NOTMODIFY}'){
								  		modifyFlag=1;
									   $("#jqxgridPMTM01").jqxGrid('setcellvalue', rowIndex, "rowStatus", '${MODIFY}');
									   return true;
								   }
							   }
							});
						
						$.ajaxSetup({
					        cache: false
					    });
						
						// Retrive Button Click Event ----------Start--------------
						$("#retrieve").jqxButton();
						$("#retrieve").click(function() {
							onRetrieve();
							$('#jqxgridPMTM01').jqxGrid('clearselection');
						});
						
						// Retrive Button Click Event ----------End--------------
						
						// Submit Button Click Event ----------Start -------------
						$("#submitbtn").jqxButton();
						$("#submitbtn").click(function() {
							formSubmission();
						});
						// Submit Button Click Event ----------End -------------
						
						
						 //**********************Create New Row **************************************************
						 $("#addrowbutton").jqxButton();
				         $("#addrowbutton").on('click', function () {
				            	//$("#jqxgridPMTM01").jqxGrid('addrow', null, {rowStatus:'${NEW_MODIFY}', errorFlag:'false'},'bottom');
				            	  $("#jqxgridPMTM01").jqxGrid('addrow', null, {rowStatus:'${NEW_MODIFY}', errorFlag:'false',statusCd:'1',status:'Active'},'top');
				            	//showDetailBtn();
				           });
				         
				         //**********************Delete Event Start************************************************
				         $("#deletebtn").jqxButton();
				         $("#deletebtn").on('click', function () {
		                        var selectedrowindex = $("#jqxgridPMTM01").jqxGrid('getselectedrowindex');
		                        var rowscount = $("#jqxgridPMTM01").jqxGrid('getdatainformation').rowscount;
		                        if (selectedrowindex >= 0 && selectedrowindex < rowscount) {
		                            var id = $("#jqxgridPMTM01").jqxGrid('getrowid', selectedrowindex);
		                            //$("#jqxgridPMTM01").jqxGrid('hiderow',id);
		                            $("#jqxgridPMTM01").jqxGrid('hiderow', id);
		                            $("#jqxgridPMTM01").jqxGrid('setcellvalue', id, "rowStatus", '${DELETE}');
		                        }
		                 });
				         
				       //*****************Start Error Message / Sucess message*****************************************************
						$("#errorMessageNotification").jqxNotification({
							width : 450,
							position : "top-right",
							opacity : 0.9,
							autoOpen : false,
							animationOpenDelay : 800,
							autoClose : false,
							autoCloseDelay : 5000,
							template : "error"
						});
				       
						var message = '${PMTM0101Form.resultModel.errorMessage}';
						if (message != "" && message != null) {
							document.getElementById("errorMessageNotification").innerText = message;
							$("#errorMessageNotification").jqxNotification("open");
							var errorField = '${PMTM0101Form.resultModel.errorField}'
							var errorProp = errorField.split(",");
							if (errorProp[0] == "header") {
								document.getElementById(errorProp[1]).style = "border-color: #FF0000;box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);"
							}
						}
						
						$("#successMessageNotification").jqxNotification({
							width : 450,
							position : "top-right",
							opacity : 0.9,
							autoOpen : false,
							animationOpenDelay : 800,
							autoClose : true,
							autoCloseDelay : 5000,
							template : "success"
						});
						
						var message = '${PMTM0101Form.resultModel.successMessage}';
						if (message != "" && message != null) {
							document.getElementById("successMessageNotification").innerText = message;
							$("#successMessageNotification").jqxNotification("open");
						}
						
						$(this).scrollTop(0);
						
						//*****************End Error Message / Sucess message*****************************************************
					});

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	
	
	function onRetrieve() {
		
		$('#jqxgridPMTM01').jqxGrid('showloadelement'); 
		flag=0;
		var frm = $("#PMTM0101Form").serializeArray();
		
		var formData = {};
		for (var a = 0; a < frm.length; a++) {
			var prop = frm[a].name.split(".");
			formData[prop[1]] = frm[a].value;
		}
		
		var formData2 = {};
		formData2["resultModel"] = formData;
		$.ajax({
			headers : {
				"Accept" : "application/json",
				"Content-Type" : "application/json"
			},
			url : functionUrlPattern + 'retrieve', // action attribute of form
			type : 'POST',
			data : JSON.stringify(formData2),
			dataType : 'json',
			success : function(res) {

				if (res.resultModel.error == false) {
					source.localdata = res.resultModel.jsonResult;
					dataAdapter.dataBind();
					$('#jqxgridPMTM01').jqxGrid('updatebounddata');
					
					showSuccessMessage(res.resultModel.successMessage);
                	hideErrorFields();
                	closeAllNotification();
				} else {
					
              	  errorMessageNotification(res.resultModel.errorMessage,document.getElementById(res.resultModel.errorField));
                }
				$('#jqxgridPMTM01').jqxGrid('hideloadelement');
			},
			error : function(error) {
				var r = jQuery.parseJSON(error.responseText);
				errorMessageNotification(r.exception+":"+r.message,null);
				$('#jqxgridPMTM01').jqxGrid('hideloadelement');
			}
		});
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

	// submit button action 
	function formSubmission() {

		var rows = $("#jqxgridPMTM01").jqxGrid('getrows');
		rows = rows.concat(deletedRow);
		var myTransferObjectJson = JSON.stringify(rows);
		document.getElementById("resultModel.jsonResult").value = myTransferObjectJson;

		$('#jqxgridPMTM01').jqxGrid('showloadelement');
		var frm = $("#PMTM0101Form").serializeArray();
		var formData = {};
		for (var a = 0; a < frm.length; a++) {
			var prop = frm[a].name.split(".");
			formData[prop[1]] = frm[a].value;
		}
		var formData2 = {};
		formData2["resultModel"] = formData;

		$.ajax({
			headers : {
				"Accept" : "application/json",
				"Content-Type" : "application/json"
			},
			url : functionUrlPattern + 'submit', // action attribute of form
			type : 'POST',
			data : JSON.stringify(formData2),
			//dataType : 'json',
			success : function(res) {
				
				if (res.resultModel.error == false) {
					showSuccessMessage(res.resultModel.successMessage);
					source.localdata = res.resultModel.jsonResult;
					dataAdapter.dataBind();
					$('#jqxgridPMTM01').jqxGrid('updatebounddata');
					hideErrorFields();
					$('#jqxgridPMTM01').jqxGrid('clearselection');
				} else {
					source.localdata = res.resultModel.jsonResult;
					dataAdapter.dataBind();
					$('#jqxgridPMTM01').jqxGrid('updatebounddata');
					$('#jqxgridPMTM01').jqxGrid('clearselection');
					showErrorFields(res.resultModel.error);
					showValidationError(res.resultModel.errorMessage, null);
				}

				$('#jqxgridPMTM01').jqxGrid('hideloadelement');
			},
			error : function(error) {
				var r = jQuery.parseJSON(error.responseText);
				showValidationError(r.exception + ":" + r.message, null);
				$('#jqxgridPMTM01').jqxGrid('hideloadelement');
			}
		});
	}

	// Check Empty Cell
	function checkIfEmpty(cellValue) {
		if (cellValue == null || cellValue == "undefined" || cellValue == '')
			return true;
		else
			return false;
	}
	
	var lastErrorElement = null;
	function lastErrorElementToBlack() {
		if (lastErrorElement != null && lastErrorElement != "") {
			document.getElementById(lastErrorElement).style = "";
			if (isText(lastErrorElement)) {
				document.getElementById(lastErrorElement).style = "";
			} else {
				document.getElementById(lastErrorElement).style = "height:25px;padding-top:1px;"
			}
		}
		lastErrorElement = null;
	}

	function showValidationError(msg, uid) {
		
		closeAllNotification();
		lastErrorElementToBlack();

		document.getElementById("errorMessageNotification").innerText = msg;
		$("#errorMessageNotification").jqxNotification("open");
		if (uid != null && uid != "") {
            var errorProp = uid.split(",");
            if(errorProp.length >0 && errorProp[0]=="detail"){
           	   $("#jqxgridPMTM01").jqxGrid('setcellvalue', errorProp[2], "errorFlag", 'true'); 
            } 
            if(errorProp.length >0 && errorProp[0]=="header"){
            	document.getElementById(errorProp[1]).style = "border-color: #FF0000;box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);"
            }
		}
	}

	
	function showErrorFields(error){
		if(error == "true" || error==true){
        	 $("#jqxgridPMTM01").jqxGrid('showcolumn', 'errorMsg');
        	 $("#jqxgridPMTM01").jqxGrid('showcolumn', 'errorCount');
		}
	}
	
	function hideErrorFields(){
		$("#jqxgridPMTM01").jqxGrid('hidecolumn', 'errorMsg');
		$("#jqxgridPMTM01").jqxGrid('hidecolumn', 'errorCount');
	}
	
	function showSuccessMessage(msg) {
		closeAllNotification();
		lastErrorElementToBlack();
		document.getElementById("successMessageNotification").innerText = msg;
		$("#successMessageNotification").jqxNotification("open");
	}

	function closeAllNotification() {
		$("#errorMessageNotification").jqxNotification("closeAll");
		$("#successMessageNotification").jqxNotification("closeAll");
	}
	
	// Employee Status Drop Down 
	function searchStatusAjax() {
		
		$.ajax({
			contentType : "application/json",
					url : "/SpringBootProject-1/helper/getActInActFlag/",
					success : function(result) {
						var flag = 0;
						var combo = document.getElementById("resultModel.status");
						combo.innerHTML = "";
						var option = document.createElement("option");
						
						for (var i = 0; i < result.length; i++) {
							statusList.push(result[i]);
							var option = document.createElement("option");
							option.text = result[i].cdData1;
							option.value = result[i].id.cdKey2;
							
							try {
								combo.add(option, null); //Standard 
							} catch (error) {
								combo.add(option);
							}
						}
					}
				})
	};

	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
</script>

	<!------------------------------------ Calendar script ---------------------------- -->

</head>
</html>