$(document).ready(function() {
	$("#jqxLoaderCommon").jqxLoader({
		isModal : true,
		width : 100,
		height : 60,
		imagePosition : 'top',
	});
	$("#jqxLoader").jqxLoader({
		isModal : true,
		width : 100,
		height : 60,
		imagePosition : 'top',
	});
	/*
	 * var a; a=1; $(".main-slide-toggle").click(function(){
	 * 
	 * if(a==1) {
	 * $("#yamaha-logo").attr('src',"${pageContext.request.contextPath}/uicommon/img/yamaha-icon.png");
	 * a=0; }
	 * 
	 * else {
	 * $("#yamaha-logo").attr('src',"${pageContext.request.contextPath}/uicommon/img/yamaha-logo.png");
	 * a=1; } });
	 */
});
var open = 1;
function toggleMenu() {// .removeClass( "tabBtn" )nav-col
	if (open == 1) {
		// $("#nav-col").css("display:none !important;");
		// $("#content-wrapper").css("margin-left: 0px !important;");

		document.getElementById("nav-col").style.display = "none"//		
		document.getElementById("content-wrapper").style.marginLeft = "0px"
		open = 0;
	} else {
		document.getElementById("nav-col").style.display = "block"//	
		document.getElementById("content-wrapper").style.marginLeft = "220px"
		open = 1;
	}
	refreshGrid();

}

function refreshGrid() {
	$('#jqxgrid').jqxGrid('pagesize', 70);
	$('#jqxgrid').jqxGrid('pagesize', 50);
}

function changeTitle(divId) {
	var currentValue = document.getElementById(divId).value;
	document.getElementById(divId).title = currentValue;
}


function clearGridOnChange()
{
		document.getElementById("jsonResult").value = '[]';
		$('#jqxgrid').jqxGrid('clear');
}

/* ************************************************************************************************************ */

function errorMessageNotification(divId, message) {
	$("#errorMessageNotification").jqxNotification({
		width : 450,
		position : "top-right",
		opacity : 0.9,
		zIndex : 100000,
		autoOpen : false,
		animationOpenDelay : 800,
		autoClose : true,
		autoCloseDelay : 3500,
		template : "error"
	});
	if (message != "" && message != null) {
		document.getElementById("errorMessageNotification").innerText = message;
		$("#errorMessageNotification").jqxNotification("open");
		if (document.getElementById(divId) != null) {
			document.getElementById(divId).style = "border-color: #FF0000; box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);"
			//	 						window.scroll(0,findPos(document.getElementById(divId)));
			//	 							$('#errorMessageNotification').jqxNotification('closeLast'); 
		}
	}
}

function showSuccessMessage(msg) {
	document.getElementById("successMessageNotification").innerText = msg;
	$("#successMessageNotification").jqxNotification("open");
}

// 		  function clearGrid(initialData,updatedData){
// 		  	   if(updatedData!=initialData){
// 					document.getElementById("resultModel.jsonResult").value = '[]';
// 					$('#jqxgrid').jqxGrid('clear');
// 		  	   }
// 			} 

/* ************************************************************************************************************ */

$(document)
		.ready(
				function() {
					$('#addFile')
							.click(
									function() {
										var fileIndex = $('#fileTable tr')
												.children().length - 1;
										if (fileIndex < 3) {
											$('#fileTable')
													.append(
															'<tr><td>'
																	+ '   <input type="file" name="files"  id="files" class="btn btn-success btn-sm epcsFile" value="Upload" style="height: 30px; padding: 4px; display: inline;margin-bottom:3px; border: none" />'
																	+ '</td></tr>');
										}
									})
				});

var storage, fail, uid;
try {
	uid = new Date;
	(storage = window.localStorage).setItem(uid, uid);
	fail = storage.getItem(uid) != uid;
	storage.removeItem(uid);
	fail && (storage = false);
} catch (e) {
}
