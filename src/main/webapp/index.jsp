<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp" />

<body>
<div class="container page-styling">
    <div class="header-wrapper">
        <div class="site-name">
            <h1>Percussion Concert Planner</h1>
        </div>
        <jsp:include page="nav.jsp" />
        <jsp:include page="banner.jsp" />
    <div class="content-wrap">
        <div class="main-title">
            <div>
                <h1>User Guide</h1>
                <table class="table table-sm">
                    <thead>
                        <tr>
                            <td>Table</td>
                            <td>Function</td>
                            <td>Method</td>
                            <td>Description</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Nationality</td>
                            <td>/services/Nationalities/xml<br>/services/Nationality/json</td>
                            <td>GET</td>
                            <td>Lists all Nationalities </td>
                        </tr>
                    <tr>
                        <td>Composer</td>
                        <td>/services/Composers/xml<br>/services/Composers/json</td>
                        <td>GET</td>
                        <td>List all Composers</td>
                    </tr>
                    <tr>
                       <td>Composer</td>
                       <td>/services/Composers/{Nationality}/xml<br>/services/Composers/{Nationality}/json</td>
                       <td>GET</td>
                       <td>Lists all composers of given nationality</td>
                    </tr>
                        <tr>
                            <td>Composer</td>
                            <td>/services/Composers/lastName/{lastName}/xml<br>/services/Composers/lastName/{lastName}/json</td>
                            <td>GET</td>
                            <td>Lists all composers of given last name</td>
                        </tr>
                    <tr>
                       <td>InstrumentCategory</td>
                       <td>/services/InstrumentCategories/xml<br>/services/InstrumentCategories/json</td>
                       <td>GET</td>
                       <td>Lists all instrument categories</td>
                    </tr>
                    <tr>
                       <td>Instruments</td>
                       <td>/services/Instruments/xml<br>/services/Instruments/json</td>
                       <td>GET</td>
                       <td>Lists all instruments</td>
                    </tr>
                        <tr>
                            <td>Instruments</td>
                            <td>/services/Instruments/{instrument}/xml<br>/services/Instruments/{instrument}/json</td>
                            <td>GET</td>
                            <td>View an individual instrument by name</td>
                        </tr>
                        <tr>
                            <td>Compositions</td>
                            <td>/services/Compositions/xml<br>/services/Compositions/json</td>
                            <td>GET</td>
                            <td>View all compositions</td>
                        </tr>
                        <tr>
                            <td>Compositions</td>
                            <td>/services/Compositions/title/{title}/xml<br>/services/Compositions/title/{title}/json</td>
                            <td>GET</td>
                            <td>View compositions by provided title</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <ul class="grid effect-8" id="grid">
                <li ><h1>Sample REST calls</h1>
                    </li>
            </ul>
            <ul class="grid effect-8" id="grid">

                <li><a href="/teamProject/services/Composers/json">All Composers (JSON)</a></li>
                <li><a href="/teamProject/services/Composers/xml">All Composers (XML)</a></li>
                <li><a href="/teamProject/services/Composers/American/json">American Composers (JSON)</a></li>
                <li><a href="/teamProject/services/Composers/American/xml">American Composers (XML)</a></li>
                <li><a href="/teamProject/services/Instruments/json">All Instruments (JSON)</a></li>
                <li><a href="/teamProject/services/Instruments/xml">All Instruments (XML)</a></li>
                <li><a href="/teamProject/services/Instruments/String/json">All String Instruments (JSON)</a></li>
                <li><a href="/teamProject/services/Instruments/String/xml">All String Instruments (XML)</a></li>
                <li><a href="/teamProject/services/InstrumentCategories/json">All Instrument Categories (JSON)</a></li>
                <li><a href="/teamProject/services/InstrumentCategories/xml">All Instrument Categories (XML)</a></li>
                <li><a href="/teamProject/services/Nationalities/json">All Nationalities (JSON)</a></li>
                <li><a href="/teamProject/services/Nationalities/xml">All Nationalities (XML)</a></li>
            </ul>

        </div>
    </div>
    <div class="lines">
        <div class="more-btn">
            <a href="#" class="btn">Read More</a>
        </div>
    </div>
    <div class="content-wrap">

        <div class="main-title spacing-bt">
            <ul class="grid effect-8" id="grid">
                <li><h1>Vivamus vest</h1>
                    <h4>Sed adipiscing ornare risus. Morbi est est, blandit sit amet, sagittis vel, euismod vel, velit. <br>
                        Pellentesque egestas sem. Suspendisse commodo ullamcorper magna..</h4></li>
            </ul>

        </div>
        <div class="row">

            <div class="featured-block">

                <div class="col-md-4">
                    <div class="icon-btn">
                        <i class="fw-icon-pencil icon"></i>
                    </div>
                    <div class="block">
                        <h5>Fusce pellentesque<br>suscipit nibh</h5>
                        <p>Sed egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus libero eu augue. Morbi purus libero,  id... </p>
                        <a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a>
                    </div>
                </div>
            </div>
            <div class="featured-block">
                <div class="col-md-4">
                    <div class="icon-btn">
                        <i class="fw-icon-group icon"></i>
                    </div>
                    <div class="block">
                        <h5>Integer vitae libero<br>ac risus egestas</h5>
                        <p>Ced egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus libero eu augue. Morbi purus libero... </p>
                        <a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a>
                    </div>
                </div>
            </div>
            <div class="featured-block">
                <div class="col-md-4">
                    <div class="icon-btn">
                        <i class="fw-icon-wrench icon"></i>
                    </div>
                    <div class="block">
                        <h5>Vestibulum commodo<br>felis quis tort</h5>
                        <p>Tegestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus libero eu augue. Morbi purus libero, fauc... </p>
                        <a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="ruler"></div>
    <div class="content-wrap centering">
        <div class="main-title spacing-bt">
            <ul class="grid effect-8" id="grid">
                <li><h1>Cras iaculis</h1>
                    <h4>Fusce lobortis lorem at ipsum semper sagittis</h4>
                </li>
            </ul>
        </div>
        <div class="featured-items">
            <ul class="grid effect-2" id="grid">
                <li>
                    <div class="item">
                        <h5>Vestibulum commodo<br> felis quis tortor</h5>
                        <div class="grow">
                            <img src="img/img1.jpg" alt="">
                        </div>
                        <p>Mauris nibh felis, adipiscing varius, adipiscing in, lacinia vel, tellus. Suspendisse ac urna. Etiam pellentesque mauris ut lectus.</p>
                        <p><a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a></p>
                    </div>
                </li>
                <li>
                    <div class="item">
                        <h5>Donec quis dui at<br> dolor</h5>
                        <div class="grow">
                            <img src="img/img2.jpg" alt="">
                        </div>
                        <p>Suspendisse mauris. Fusce accumsan mollis eros. Pellentesque a diam sit amet mi ullamcorper vehicula. Integer adipiscing risus</p>
                        <p><a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a></p>
                    </div>
                </li>
                <li>
                    <div class="item">
                        <h5>Vestibulum commodo<br> felis quis tortor</h5>
                        <div class="grow">
                            <img src="img/img3.jpg" alt="">
                        </div>
                        <p>Mauris nibh felis, adipiscing varius, adipiscing in, lacinia vel, tellus. Suspendisse ac urna. Etiam pellentesque mauris ut lectus.</p>
                        <p><a href="#" class="more">more info <i class="fw-icon-chevron-right"></i></a></p>
                    </div>
                </li>
            </ul>



        </div>
    </div>
    <div class="ruler"></div>
    <div class="content-wrap centering">
        <div class="main-title">
            <ul class="grid effect-8" id="grid">
                <li>  <h1>Nunc digniss</h1>
                    <h4>Praesent dapibus, neque id cursus faucibus,<br>
                        tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat <br>
                        volutpat. Nam dui mi, tincidunt quis, accumsan porttitor</h4></li>
            </ul>
        </div>
        <div class="tags">
            <h5 class="spacing-bt">lorem ipsum dolor</h5>
            <ul class="grid effect-7" id="grid" >
                <li><a href="#" class="btn">Integer vit ametuno</a></li>
                <li><a href="#" class="btn">donce ametuno </a></li>
                <li><a href="#" class="btn">voluptanin </a></li>
                <li><a href="#" class="btn">tincidun </a></li>
                <li><a href="#" class="btn">porttion souti </a></li>
                <li><a href="#" class="btn">namdui sinosi</a></li>
                <li><a href="#" class="btn">fermnutin </a></li>
            </ul>


        </div>
    </div>
    <div class="lines">
        <div class="more-btn">
            <a href="#" class="btn">View More</a>
        </div>
    </div>

</div><!-- /container -->

<div class="container">
    <div class="copy-rights">
        Copyright(c) website name.<br>
        Designed by:<a href="http://www.alltemplateneeds.com"> www.alltemplateneeds.com</a>  /  Images from:<a href="http://www.wallpaperswide.com"> www.wallpaperswide.com</a>
    </div>
</div>

    <jsp:include page="scripts.jsp" />
</body>
</html>
