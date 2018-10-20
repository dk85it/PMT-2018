<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.h2.util.StringUtils"%>
<%@page import="java.util.Date"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:out value="${pageContext.request.contextPath}" />/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/uicommon/js/ymsli.nanoscroller.min.js"></script>
<script
	src="<c:out value="${pageContext.request.contextPath}" />/uicommon/js/scripts.js"></script>
<script
	src="${pageContext.request.contextPath}/uicommon/js/ymsli.maskedinput.min.js"></script>
<script
	src="${pageContext.request.contextPath}/uicommon/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="<c:out value="${pageContext.request.contextPath}" />/uicommon/js/bootstrap-timepicker.min.js"></script>
<script type="text/javascript"
	src="<c:out value="${pageContext.request.contextPath}" />/uicommon/js/trip.min.js"></script>

<link rel="stylesheet"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/libs/bootstrap-timepicker.css"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/uicommon/css/ymsli_grid.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/uicommon/css/pj_common.css" />

<script type="text/javascript"
	src="<c:out value="${pageContext.request.contextPath}" />/js/jqwidgets/jqx-all.js"
	defer></script>
<script
	src="${pageContext.request.contextPath}/resources/js/loader/modernizr.js"></script>
<script type="text/javascript"
	src="<c:out value="${pageContext.request.contextPath}" />/uicommon/js/demo-rtl.js"></script>


<script type="text/javascript"
	src="<c:out value="${pageContext.request.contextPath}" />/uicommon/js/bootstrap-maxlength.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/bootstrap/trip.min.css" />
	<script type="text/javascript"
	src="<c:out value="${pageContext.request.contextPath}" />/uicommon/js/bootstrap-typeahead.js"></script>
<!-- this page specific styles -->
<script type="text/javascript"
	src="<c:out value="${pageContext.request.contextPath}" />/uicommon/js/bootstrap-typeahead.min.js"></script>
	
	<script type="text/javascript"
	src="<c:out value="${pageContext.request.contextPath}" />/uicommon/js/bootstrap-3.3.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/libs/font-awesome.css" />
<link rel="stylesheet" type="text/css"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/compiled/theme_styles.css" />
<!-- this page specific styles -->
<link rel="stylesheet"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/libs/fullcalendar.css"
	type="text/css" />
<link rel="stylesheet"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/libs/fullcalendar.print.css"
	type="text/css" media="print" />
<link rel="stylesheet"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/compiled/calendar.css"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/libs/datepicker.css"
	type="text/css" />
<link rel="stylesheet"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/libs/daterangepicker.css"
	type="text/css" />
<link
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/css/custom.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/uicommon/css/ymsli_grid.css" />
<!-- Favicon -->
<link type="image/x-icon"
	href="<c:out value="${pageContext.request.contextPath}" />/uicommon/img/logo-icon.ico"
	rel="shortcut icon" />

<style>
.feedback {
  background-color : #31B0D5;
  color: white;
  border-radius: 10px;
  border-color: #46b8da;
  opacity:0.5;
  z-index:999999;
}

.feedback:hover{
opacity:1;
}

#mybutton {
  float :right;
  position: fixed;
  bottom: 2%;
  right: 0px;
}


.target {
  border: solid 1px #aaa;
  min-height: 300px;
  width: 100%;
  margin-top: 1em;
  border-radius: 5px;
  cursor: pointer;
  overflow:scroll;
  transition: 300ms all;
  position: relative;
}

.contain {
    background-size: cover;
  position: relative;
  z-index: 10;
  top: 0px;
  left: 0px;
}

#contactUsModal,#extClientCountModal > .modal-dialog {
   top: 30%;
/*    right: 100px; */
   bottom: 0;
   left: 0;
}

#contactUsModal,#extClientCountModal > .modal-backdrop{
    height: 21em !important;
    width: 26.2em;
    left: 35.7em;
    top: 29%;
    background-color: transparent;
}

</style>

<script>
	$(window).load(function() {
		//document.location.href="#top";
		$('.loaderButton').click(function() {
			$('#spinner').show();
		});
		$('.downlaodButton').click(function() {
			$('#spinner').show();
			setTimeout(function() {
				$('#spinner').hide();
			}, 1000);
		});
	});
	function commonRedirect(formName, url) {
		var form = document.forms[formName];
		form.action = url;
		form.target = "_self";
		form.submit();
	}
	
	function openURL(moduleCd)
	{
		var d = new Date();
	    d.setTime(d.getTime() + (1*24*60*60*1000));
	    var expires = "expires="+ d.toUTCString();
	    document.cookie = "moduleCd=" + moduleCd + ";" + expires + ";path=/";
	    
	}
</script>

</head>
<body class="theme-whbl">
	<div id="spinner" class="spinner">
		<div class="spinner-text">
			<img id="img-spinner"
				src="${pageContext.request.contextPath}/uicommon/img/Preloader_3.gif"
				alt="Loading" /> <span class="text">Please Wait... </span>
		</div>
	</div>

	<div id="theme-wrapper">
		<header class="navbar" id="header-navbar">
			<div class="container">
				<a class="navbar-brand">
				<span class="form-group">
				 <img id="yamaha-logo"
					style="margin-top:-5px;margin-left:15px"
					src="${pageContext.request.contextPath}/uicommon/img/yamaha-logo.png"
					alt="">
				<i class="fa fa-bars  fa-1x" onclick="toggleMenu();" aria-hidden="true" style="color:white;margin-left: 41px;cursor:pointer"></i>
				</span>
				</a>
				<div class="clearfix">
					<div
						class="nav-no-collapse main-slide-toggle navbar-left pull-left hidden-sm hidden-xs">

						<ul class="nav navbar-nav pull-left">
							<li class="main-head">
								<h1>IYM TEST REPORTS</h1>
							</li>
						</ul>
					<div id="jqxLoaderCommon"></div>
					</div>
					<div class="nav-no-collapse pull-right" id="header-nav">
						<ul class="nav navbar-nav pull-right">
							
												
							<li class="navbar-nav home" id="home" title="Home">
								<%
									String moduleCd2 = (String) session.getAttribute("module");
									if (StringUtils.equals(moduleCd2, "1401")) {
								%> 
								<a id="drop1" href="${pageContext.request.contextPath}/home" style="font-size:1em"
								    role="button"><i class="fa fa-home homeIcon" aria-hidden="true"
									 ></i></a> <%
 								}
								    %>
							</li>
							

							<li class="dropdown profile-dropdown"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown"><span
									class="hidden-xs"> [<c:out
											value="${UserContext.userName}" />]
								</span><span class="hidden-xs">
										<%
											Date date = new Date();
										%> <%
 											SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
 											%>
										[<%=sdf.format(date)%>]
								</span> </a></li>
								
								<li class="dropdown dropdownFunction nav navbar-nav "
								id="dropdownFunction1" role="button"><a href="${pageContext.request.contextPath}/logout" id="drop1" style="font-size:1em"
								role="button"><i class="fa fa-power-off iconTopMenu" aria-hidden="true"
									></i></a>
								
							</li>

						</ul>
					</div>
				</div>
				<div class="col-lg-1" id="ymisAdminBtnBlock" style="display:none" >
						 	<a id="adminRedirect" href=""><input type="button" id="adminBtn" class=" tabBtn"
								onclick="toggleYmisAdmin()" value="ADMIN"></a>
		       </div>
			</div>
			<div id="mybutton">
				<button class="feedback" id="clearLogin" data-toggle="modal" style="display:none" data-target="#contactUsModal" >
					<i class="fa fa-envelope"></i>
				</button>
			</div>
		</header>
		<div id="page-wrapper" class="container">
			<div class="row">
				<div id="nav-col">
					<section id="col-left" class="col-left-nano">
						<div id="col-left-inner" class="col-left-nano-content">

					<div class="collapse navbar-collapse navbar-ex1-collapse"
								id="sidebar-nav">
						<ul class="nav nav-pills nav-stacked">
								<%String moduleCd1 = (String)session.getAttribute("module");
							
							if(StringUtils.equals(moduleCd1, "1401")){
								%>
								<c:forEach items="${UserContext.menu.submoduleFunction}" var="map">
									<li class="open" style="padding-top: 1.3em;"><a href="#"
										class="dropdown-toggle menu-header breadcrumb"> <i  class="fa fa-desktop fa-1x icon_brief" id="iconNavbar"
											style="background-color: blue;padding-top: 3.2%;"></i> <span>${map.key}</span> <i
											class="fa fa-chevron-circle-right drop-icon"></i>
									</a>
									<ul class="submenu" style="display:block">
									<c:forEach items="${map.value}" var="link">
                                 	<li class="submenuLi"><a
												href="${pageContext.request.contextPath}${link.url}" onclick="openURL('1401')">
													<span class="color-black"> ${link.functionName} </span>
											</a></li>								
                                 </c:forEach>
                                 
                                 </ul>
										</c:forEach> 
								<%} %>
								
						</ul>
					</div>
						</div>
					</section>
				</div>
			</div>
		</div>
	</div>
	<div id="contactUsModal" class="modal fade" role="dialog"
		style="z-index: 10000">
		<div class="modal-dialog  modal-sm">
			<div class="modal-content" style="border-radius: 10px">
				<div class="modal-header"
					style="background: #41ACEA; padding: 8px; border-radius: 10px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style="color: white">Login As</h4>
				</div>
				
			 <div class="modal-body">
					<div class="row" style="margin-top: 10px;">
								<div class="form-group">
									<label for="username">Access Id</label>
									 <input type="text" autofocus="autofocus"
													class="form-control input-sm col-md-1"
													style="height:25px;padding-top:1px" id="username" data-provide="typeahead"
													placeholder="Enter Name/EIN " autocomplete="off" />
								</div>
								<a id="anchorToGo"><button id="loginBtn" type="submit" class="btn" onclick="changeUser()">Login</button></a>
								<!-- <button type="submit" class="btn">Sign in!</button> -->
					</div>
					<!-- <div class="span4 target"></div> -->
				</div> 
			</div>
		</div>
	</div>
	<script>
	
	var val2 = [];
	 $(document).ready(function() {
		 checkIfUserIsAdmin();
		 checkIfUserIsDeveloper();
		/*  $('#username').typeahead({
				onSelect: function(item) {	
					var itemValue = item.value;
					$('#username').val('');
					var itemValueEin = itemValue.split("-")
					document.getElementById("username").value =itemValueEin[0].trim();
					changeUser();
			    		}, 
			 source: val2,
		   }); */
	 });
	 
	 function getAllClientsForLogin() {
			var model = {}
			$.ajax({
				async: false,
				contentType : "application/json",
				url : "${pageContext.request.contextPath}/helper/getAllEmployeeForLogin",
				dataType : 'json',
				success : function(data) {
					var i=0
					for ( ; i < data.length; i++) {
						var d =data[i] ;
							val2[i] =d.code+"-"+d.name;
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
			
		} 	
	 
	 function changeUser(){
		    var currentUrl = window.location.pathname;
			delimiter = "/";
			start = 2;
			tokens = currentUrl.split("/").slice(2);
			result = 	tokens.join(delimiter);
			 var userId = document.getElementById("username").value;
			 var anchor = document.getElementById("anchorToGo");
			 url = '${pageContext.request.contextPath}/quickLogin?userId='+userId+"&returnTo="+result,
			 anchor.setAttribute("href",url)
		 }
	 
	 function changeHref(){
		 	var id = $(this).attr('id');
		    url = '${pageContext.request.contextPath}/checkAndSetMenu?urlToHit='+id,
			document.getElementById(id).setAttribute("href",url)
//			return false
	}
	
	var isOpenDiv = 0;
	 $('#dropdownFunction1').click(function() {
				var moduleName = ${module}
				if (isOpenDiv == 0) {
					$('#menu-HeaderDropdown').show();
					if (moduleName == "501") {
						if(document.getElementById('dropdownMenuEPCS')!=null)
							document.getElementById('dropdownMenuEPCS').style.display = 'block';
						if(document.getElementById('dropdownMenuHelpdesk')!=null)
							document.getElementById('dropdownMenuHelpdesk').style.display = 'block';
						if(document.getElementById('dropdownMenuDMS')!=null)
							document.getElementById('dropdownMenuDMS').style.display = 'block';
						if(document.getElementById('dropdownMenuDTS')!=null)
							document.getElementById('dropdownMenuDTS').style.display = 'block';
					}
					isOpenDiv = 1;
				} else {
					$('#menu-HeaderDropdown').hide();
					isOpenDiv = 0;
				}
			 
	    });
	 	var adminOpened = 0;
		var adminGlobalFlag = ${userAdmin};
		var adminIsUpFlag = ${adminIsUp};
		function checkIfUserIsAdmin() {
			var currentUrl = window.location.href;

			if (adminGlobalFlag == "1"
					&& !(window.location.href.indexOf("detail") != -1)
					&& !(window.location.href.indexOf("back") != -1)
					&& !(window.location.href.indexOf("reset") != -1)
					&& !(window.location.href.indexOf("reviewIarWork") != -1)
					&& !(window.location.href.indexOf("uploadTemplate") != -1)) {
				document.getElementById("ymisAdminBtnBlock").style.display = 'block'
				if (adminIsUpFlag) {
					adminOpened = 1;
					$("#adminBtn").removeClass("tabBtn").addClass(
							"adminBtnActive");
				} else {
					adminOpened = 0;
					$("#adminBtn").removeClass("adminBtnActive").addClass(
							"tabBtn");
				}
			} else {

			}
		}
	 	
	 	var developerFlag = ${isDeveloper};
		function checkIfUserIsDeveloper() {
			var currentUrl = window.location.href;
			if (developerFlag == "1"
					&& !(window.location.href.indexOf("detail") != -1)
					&& !(window.location.href.indexOf("reset") != -1)
					&& !(window.location.href.indexOf("reviewIarWork") != -1)) {
				document.getElementById("clearLogin").style.display = 'block'
			} else {

			}
		}

		function toggleYmisAdmin() {
			var adminIsUpFlagOpened = ${adminIsUp};
			var alreadyAdmin = "NO";
			if (adminIsUpFlagOpened == 0)
				alreadyAdmin = "NO";
			 else
				alreadyAdmin = "YES"
			
			$('#jqxLoaderCommon').jqxLoader('open');
			var currentUrl = window.location.pathname;
			delimiter = "/";
			start = 2;
			tokens = currentUrl.split("/").slice(2);
			result = tokens.join(delimiter);
			url = "/itr/toggleAdmin?alreadyAdmin=" + alreadyAdmin
					+ "&currentUrl=" + result;
			document.getElementById("adminRedirect").setAttribute("href",
					url)
			$('#jqxLoaderCommon').jqxLoader('close');
		}

		$(document).ready(function() {
			// 			checkIfUserIsAdmin();
			// 			checkIfUserIsAdmin();
			/* initialize the external events
			-----------------------------------------------------------------*/

			$('#external-events div.external-event').each(function() {

				// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
				// it doesn't need to have a start or end
				var eventObject = {
					title : $.trim($(this).text())
				// use the element's text as the event title
				};

				// store the Event Object in the DOM element so we can get to it later
				$(this).data('eventObject', eventObject);

				// make the event draggable using jQuery UI
				$(this).draggable({
					zIndex : 999,
					revert : true, // will cause the event to go back to its
					revertDuration : 0
				//  original position after the drag
				});

			});

		});

		(function backAjaxWorker() {
			// alert("inside")
			$.ajax({
				contentType : "application/json",
				dataType : 'json',
				url : '${pageContext.request.contextPath}/isSessionAlive',
				success : function(data) {
				},
				complete : function(data) {
					if (data.responseText == null || data.responseText == "NO"
							|| data.responseText != "YES") {
						alert("Your Session Has been Expired! Login Again!")
					} else {
					}
					// Schedule the next request when the current one's complete
					var waitTime = 31 * 60 * 1000;
					// 					var waitTime = 2 * 60 * 1000;
					setTimeout(backAjaxWorker, waitTime);
				}
			});
		})();

	</script>
	<script
		src="${pageContext.request.contextPath}/uicommon/js/ymsli_main.js"></script>
</body>
</html>
