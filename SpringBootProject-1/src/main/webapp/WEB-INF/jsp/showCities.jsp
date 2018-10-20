<!DOCTYPE html>
<html>

<head>
    <title>Select Direct Reports</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link rel="STYLESHEET" type="text/css" href="include/dhtmlx.css">
    <script src="include/dhtmlx.js"></script>
    <%@ include file="/WEB-INF/share/includes/menu.jsp"  %>
    <style>
		.even{
			background-color:silver;
		}
		.uneven{
			background-color:white;
		}
	</style>
    <script>
    
    var myGrid;
	function doOnLoad(){
		
			mygrid = new dhtmlXGridObject('gridbox');
	        mygrid.setImagePath("include/imgs/");
	    	mygrid.setHeader("Id,Name,Population");
	        mygrid.setInitWidths("100,200,100");
	    	mygrid.setColAlign("left,left,left");
	    	mygrid.setColumnIds("id,name,population");
	    	mygrid.setColTypes("ro,ed,ed");
	    	mygrid.setColSorting("str,str,str");
	    	/* mygrid.attachEvent("onCheck", doOnChecked);
	    	mygrid.attachEvent("onRowSelect", doOnRowSelected); */
	    	mygrid.init();
		
	    	mygrid.load("http://localhost:8080/SpringBootProject-1/api/city/", "js");
		
	}
	
	function addRows(){
		var rowId=mygrid.uid();
		var pos = mygrid.getRowsNum();  //gets the number of rows in grid
		mygrid.addRow(rowId,["","",""],0);
	}
    </script>
</head>
<body onload='doOnLoad()'>

<table>
	<tr>
		<td valign="top">
				<div id="gridbox" style="width:470px;height:300px;background-color:white; "></div>
		</td>
	</tr>
	<tr>
			<td>
				<div><input id='z1' type="button" onclick='addRows();' value='Add Rows'></div>
			</td>
		</tr>
</table>
    
</body>
</html>
