<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="PMTM0101Js.jsp" />
<!DOCTYPE html>
<html>
<body>
	<div id="errorMessageNotification"
		style="display: none; margin-top: 50px">
		<div>
			<br> <br> <br> <br>
		</div>
	</div>
	<div id="jqxLoader"></div>
	<div id="successMessageNotification"
		style="display: none; margin-top: 50px;">
		<div>
			<br> <br> <br> <br>
		</div>
	</div>
	
	<div id="content-wrapper">
		<div class="row" style="opacity: 1;">
			<div class="col-lg-12">
				<div class="row">
					<div class="col-lg-12 ">
						<div class="main-box">
							<div class="main-box-body clearfix">
								<div class="row"></div>
								<form:form action="PMTM0101Form" method="post" modelAttribute="PMTM0101Form" class="form-horizontal" id="PMTM0101Form">
									<div id="container">
										<div class="col-lg-3" style="display: none;">
											<form:select path="resultModel.status"
												class="form-control input-sm label-box"
												id="resultModel.status" style="height:25px;padding-top:1px"/>
										</div>
									<div class="row top-margin">
										<div class="col-lg-1" align="right">
											<label class="label_style" for="resultModel.ein"><spring:message code="label.empId" /></label>
										</div>
										<div class="col-md-2">	
											<form:input path="resultModel.ein" class="form-control text-input-half input-sm"  style="height: 25px;" onkeyup="this.value = this.value.toUpperCase();"/>
											<form:hidden path="resultModel.jsonResult" id = "resultModel.jsonResult" />
										</div>
										<div class="col-lg-2" align="right">
											<label class="label_style" for="resultModel.dobDate"><spring:message code="label.empDate" /></label>
										</div>
										<div class="col-md-2">
											<div class="row">
												<div class="col-lg-12">
													<div class="input-group">
														<form:input path="resultModel.dobDate"
															class="form-control input-sm input-div" size="8"
															placeholder="--(DD/MM/YYYY)--" id="resultModel.dobDate"
															readonly="false" />
														<span class="input-group-addon calSpan"
															style="background-color: #fff; height: 25px; padding-top: 0px; padding-bottom: 0px;"
															onclick="openCalender()">
															<i class="fa fa-calendar"></i></span>	
														<div id='jqxcalendar' style="display: none;"></div>
													</div>
												</div>
											</div>
										</div>
										
										<div class="col-md-2">
											<div class="row">
												<div class="col-lg-12">
													<div class="input-group">
														<form:input path="resultModel.dobDateTo"
															class="form-control input-sm input-div" size="8"
															placeholder="--(DD/MM/YYYY)--" id="resultModel.dobDateTo"
															readonly="false" />
														<span class="input-group-addon calSpan"
															style="background-color: #fff; height: 25px; padding-top: 0px; padding-bottom: 0px;"
															onclick="openCalender1()">
															<i class="fa fa-calendar"></i></span>	
														<div id='jqxcalendar1' style="display: none;"></div>
													</div>
												</div>
											</div>
										</div>
										<div class=" pull-right">
											<input type="button" class="btn btn-success pull-right btn-sm" id="retrieve" style="margin-right: 5px" value="Retrieve"/>
										</div>
									</div>
									<!-- ==============================jqxgrid Div============================== -->
									<div class="row " style="margin-top: 5px;">
										<div class="col-lg-12">
											<div align="center">
												<div id="jqxgridPMTM01"></div>
											</div>
										</div>
									</div>
									
									<div class="row top-margin">
											<div class=" col-lg-2 pull-left">
												<input type="button" class="btn btn-success btn-sm" id="addrowbutton" value="Insert" /> 
												<input type="button" class="btn btn-success btn-sm" id="deletebtn" value="Delete" />
											</div>
										</div>
										
									<div class="row">
											<div class="top-margin">
												<div class=" pull-left" style="margin-left: 1px">
													<input type="button" class="btn btn-success btn-sm" id="submitbtn" value="Submit"/>
													<button type="button" class="btn btn-success btn-sm"
														style="" id="detail">Detail</button>
													<button type="button" class="btn btn-success btn-sm"
														style="" id="downloadBtn" onclick="download()">Download</button>	
												</div>
												<div class=" pull-right">
													<button type="submit" id='resetBtn' onclick="commonRedirect('PMTM0101Form','${pageContext.request.contextPath}/pmtm/pmtm01/pmtm0101')" 
															class="btn btn-success btn-sm pull-right"
															formaction="${pageContext.request.contextPath}/pmtm/pmtm01/pmtm0101">Reset</button>
												</div>
											</div>

										</div>
										

										
										
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!------------------------------global script starts here ------------------------------->
	<script type="text/javascript">
		$(document).ready(function() {

			$("#jqxcalendar").jqxCalendar({
				width : '200px',
				height : '200px'
			});
			
			$("#jqxcalendar1").jqxCalendar({
				width : '200px',
				height : '200px'
			});
		});
		
		/********************Request Apply date Start date calendar  *************************************/

		function closeAllCalendar() {
			closeCalender();
		}

		var flagCalender = 0;
		function openCalender() {
			if (flagCalender == 1) {
				closeCalender();
			} else {
				closeAllCalendar();
				document.getElementById("jqxcalendar").style.display = "block";
				flagCalender = 1;
			}
		}
		function closeCalender() {
			flagCalender = 0;
			document.getElementById("jqxcalendar").style.display = "none";
		}	
		
		$('#jqxcalendar')
		.on(
				'change',
				function(event) {
					var targetString = $(event.target).text();
					var n;
					if (targetString != null) {
						n = targetString.search("123456789");
					}
					if (n >= 0) {
						var jsDate = event.args.date;
						var month = jsDate.getMonth() + 1;
						if (month < 10)
							month = '0' + month;
						var day = jsDate.getDate();
						if (day < 10)
							day = '0' + day;
						document.getElementById("resultModel.dobDate").value = day
								+ '/'
								+ month
								+ '/'
								+ jsDate.getFullYear();
						closeCalender();
					}
				});

/********************Request Apply date End To date calendar  *************************************/


var flagCalender1 = 0;
		function openCalender1() {
			if (flagCalender1 == 1) {
				closeCalender1();
			} else {
				closeAllCalendar();
				document.getElementById("jqxcalendar1").style.display = "block";
				flagCalender1 = 1;
			}
		}
		function closeCalender1() {
			flagCalender1 = 0;
			document.getElementById("jqxcalendar1").style.display = "none";
		}

		$('#jqxcalendar1')
				.on(
						'change',
						function(event) {
							var targetString = $(event.target).text();
							var n;
							if (targetString != null) {
								n = targetString.search("123456789");
							}
							if (n >= 0) {
								var jsDate = event.args.date;
								var month = jsDate.getMonth() + 1;
								if (month < 10)
									month = '0' + month;
								var day = jsDate.getDate();
								if (day < 10)
									day = '0' + day;
								document
										.getElementById("resultModel.dobDateTo").value = day
										+ '/'
										+ month
										+ '/'
										+ jsDate.getFullYear();
								closeCalender1();
							}
						});
		/********************Request Apply date End To date calendar  *************************************/
		
	</script>	
		
</body>
</html>