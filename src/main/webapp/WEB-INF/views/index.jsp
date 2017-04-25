<!DOCTYPE html>
<html lang="en">
<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>SQL Server Helper</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/resources/css/colorpicker.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/resources/css/datepicker.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/resources/css/uniform.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/resources/css/select2.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/resources/css/matrix-style.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/resources/css/matrix-media.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-wysihtml5.css" rel="stylesheet"/>
<link href="${pageContext.servletContext.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">SQL Server</a></h1>
</div>
<!--close-Header-part--> 
<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-fullscreen"></i></a>
  <ul id="gritter-notify">
    <li><a href=""><i class="icon-question-sign"></i> <span>How it works</span></a> </li>
           <div class="widget-content notify-ui">
            <ul id="gritter-notify">
           
             <li><a title="" id="example" data-content="Add the following stored procedure to all applicable
              test instances" data-placement="right" data-toggle="popover" href="" data-original-title="<b>Information</b>" > <span class="label label-important">1</span> Add This Stored Procedure </a> </li>             
            	
            
              <li><a title="" id="example" data-content="Simply choose the SQL instance you want to backup
              and press the Backup button, enter the zip name on the popup and a .zip will be generated
              containing all the non-system databases of that instance." data-placement="right" data-toggle="popover" href="" data-original-title="<b>Information</b>" > <span class="label label-important">2</span> Backup any sql instance &nbsp&nbsp&nbsp</a> </li>             
            	
             
              <li><a title="" id="example" data-content="Completely nuke all non-system databases on a SQL instance, always
              backup in step #1 before executing this functionality as it will be permanently lost." data-placement="right" data-toggle="popover" href="" data-original-title="<b>Information</b>" > <span class="label label-important">3</span> Delete all sql databases &nbsp&nbsp&nbsp&nbsp</a> </li>             
            	
              <li><a title="" id="example" data-content="Select the Restore option and choose the zip that you want to
              restore onto the instance. <b>note: </b> any file with the .zip extension on .1 C:/SQLBackup directory will be listed
              " data-placement="right" data-toggle="popover" href="" data-original-title="<b>Information</b>" > <span class="label label-important">4</span> Restore any sql instance &nbsp&nbsp&nbsp</a> </li>                       	         
            </ul>
       
  </ul>
  </div>
</div>


<!--close-left-menu-stats-sidebar-->

<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="" title="SQL Server Database Helper" class="tip-bottom"><i class="icon-home"></i> SQL Server Instance Manager</a> </div>
  <h1><b>QA - Microsoft SQL Server Manager</b></h1>
</div>
<div class="container-fluid">
<hr>
<div class="row-fluid">
		 <div class="span12">
        <div class="alert alert-info">
              <button class="close" data-dismiss="info">×</button>
              <center><span class="label label-important">Important</span> Clearing a database <strong> WILL </strong> delete all
              non system databases in that instance</center>
          </div>
     
   

<div class="row-fluid">
 <div class="span4">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-ok-sign"></i> </span>
            <h5><code>Step One:</code> Backup A Local SQL Instance</h5> 
          </div>
          
          <div class="progress-striped progress progress-info active">          
 		<div class="bar" style="width: 100%;"></div>  
        
          <div class="widget-content"><span class="label label-inverse">1</span> Send a request and add a new external user, unique ID <strong>cannot</strong> be duplicate </div>
        </div>    
      </div>
      </div>
      
      <div class="span4">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-ok-sign"></i> </span>
            <h5><code>Step Two:</code> Clear Out A SQL Instance</h5>          
          </div>         
          <div class="progress-striped progress progress-danger active">          
 		<div class="bar" style="width: 100%;"></div>     
 		
      </div>
      </div>
      </div>
      <div class="span4">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-ok-sign"></i> </span>
            <h5><code>Step Three:</code> Restore A Backup</h5>
          </div>
         <div class="progress-striped progress progress-success active">          
 		<div class="bar" style="width: 100%;"></div>        
      </div>
      </div>   
      </div>
      </div>
		 
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
            <h5>SQL Instances</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>Database Instance</th>
                  <th>Options</th>
                  <th>Instance Online</th>
                </tr>
              </thead>
              <tbody>
         
                 <tr class="gradeX">
                   <c:forEach items="${dbs}" var="instance">
                  <tr>
                  <td align="center">
                  <b><font size="2">${instance.getName()} </font></b></td>
                  <td align="center">
                  <c:choose>
				  <c:when test="${instance.isOnline()}">
				  <center>
                  	<button class="btn btn-info btn-sm"><i class="icon-cloud-download"></i> Backup Instance</button>
                  	<button class="btn btn-danger btn-sm"><i class="icon-bullseye"></i> Clear Instance</button>
  					<button class="btn btn-success btn-sm"><i class="icon-cloud-upload"></i> Restore Instance</button>
  				 </center>
  					</c:when>
					    <c:when test="${!instance.isOnline()}">
					<center>
					<button class="btn btn-info btn-sm disabled"><i class="icon-cloud-download"></i> Backup Instance</button>
                  	<button class="btn btn-danger btn-sm disabled"><i class="icon-bullseye"></i> Clear Instance</button>
  					<button class="btn btn-success btn-sm disabled"><i class="icon-cloud-upload"></i> Restore Instance</button>
  					</center>
					    </c:when>
					</c:choose>
  					
  					
					</td>
					<td align="center">
					<c:choose>
					    <c:when test="${instance.isOnline()}">
					    <center>
					      <span class="label label-success">Server Online</span>
					    </center>
					    </c:when>
					    <c:when test="${!instance.isOnline()}">
					    <center>
					        <span class="label label-important">Server Offline</span>
					    </center>
					    </c:when>
					</c:choose>
					</tr>
				
					</c:forEach>
          
              </tbody>
            </table>
	        </div>
	        </div>
	        </div>

         <div class="span4">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
            <h5>Existing Backups</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>Version Name</th>
                  <th>Filesize</th>   
                  <th>TimeStamp</th>                            
                </tr>
              </thead>
              <tbody>
               
                 <c:forEach items="${list}" var="backup">
                 </tr>
                 <tr class="gradeX">
				  <td align="center"><center><b><font size="3"> ${backup.getFileName()}</font></b></center></td>
                  <td align="center"><center>${backup.getFileSize()} <b> MB</b></center></td>
                  <td align="center"><center>${backup.getTimeStamp()} </center></td>
                  </tr>
			  </c:forEach>    
    
                </tr>                          
              </tbody>
            </table>
          </div>
        </div>
      
      </div>     
    </div>

    
        
          
          
      
<!--end-Footer-part--> 
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.ui.custom.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-colorpicker.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-datepicker.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.toggle.buttons.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/masked.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.uniform.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/select2.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/matrix.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/matrix.form_common.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/wysihtml5-0.3.0.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.peity.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-wysihtml5.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.ui.custom.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.peity.min.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/matrix.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/matrix.interface.js"></script> 
<script src="${pageContext.servletContext.contextPath}/resources/js/matrix.popover.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.gritter.min.js"></script>
<script>
	$('.textarea_editor').wysihtml5();
</script>
</body>
</html>
