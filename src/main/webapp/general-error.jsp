<%--
  Created by IntelliJ IDEA.
  User: Xinan
  Date: 4/6/2018
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../head.jsp" />

<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Percussion Concert Planner</h1>
        </div>
        <jsp:include page="../nav.jsp" />
        <jsp:include page="../banner.jsp" />
        <div class="content-wrap">
            <div class="main-title">
                <ul class="grid effect-8" id="error">
                    <li ><h1>General Error</h1>
                        <h4>You have reached an error page!<br>
                            Please make sure you have access to the webpage you are requesting.</h4></li>
                </ul>
                <ul class="grid effect-8" id="grid">

                    <li><a href="/concertPlanner/services/Composers/json">All Composers (JSON)</a></li>
                    <li><a href="/concertPlanner/services/Composers/xml">All Composers (XML)</a></li>
                    <li><a href="/concertPlanner/services/Composers/American/json">American Composers (JSON)</a></li>
                    <li><a href="/concertPlanner/services/Composers/American/xml">American Composers (XML)</a></li>
                    <li><a href="/concertPlanner/services/Instruments/json">All Instruments (JSON)</a></li>
                    <li><a href="/concertPlanner/services/Instruments/xml">All Instruments (XML)</a></li>
                    <li><a href="/concertPlanner/services/Instruments/String/json">All String Instruments (JSON)</a></li>
                    <li><a href="/concertPlanner/services/Instruments/String/xml">All String Instruments (XML)</a></li>
                    <li><a href="/concertPlanner/services/InstrumentCategories/json">All Instrument Categories (JSON)</a></li>
                    <li><a href="/concertPlanner/services/InstrumentCategories/xml">All Instrument Categories (XML)</a></li>
                    <li><a href="/concertPlanner/services/Nationalities/json">All Nationalities (JSON)</a></li>
                    <li><a href="/concertPlanner/services/Nationalities/xml">All Nationalities (XML)</a></li>
                </ul>

            </div>
        </div>


        <div class="container">
            <div class="copy-rights">
                Copyright(c) website name.<br>
                Designed by:<a href="http://www.alltemplateneeds.com"> www.alltemplateneeds.com</a>  /  Images from:<a href="http://www.wallpaperswide.com"> www.wallpaperswide.com</a>
            </div>
        </div>

        <jsp:include page="../scripts.jsp" />
</body>
</html>
