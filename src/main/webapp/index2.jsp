<%--
  Created by IntelliJ IDEA.
  User: pattsai
  Date: 12/4/21
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Backend API - Documentation</title>
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<nav class="nav" role="navigation">
  <ul class="nav__list">
    <li>
      <input id="group-1" type="checkbox" hidden />
      <label for="group-1"><span class="fa fa-angle-right"></span> First level</label>
      <ul class="group-list">
        <!--<li><a href="#">1st level item</a></li>-->
        <li>
          <input id="sub-group-1" type="checkbox" hidden />
          <label for="sub-group-1"><span class="fa fa-angle-right"></span> Second level</label>
          <ul class="sub-group-list">
            <li><a href="#">2nd level nav item</a></li>
            <li><a href="#">2nd level nav item</a></li>
            <li><a href="#">2nd level nav item</a></li>
            <li>
              <input id="sub-sub-group-1" type="checkbox" hidden />
              <label for="sub-sub-group-1"><span class="fa fa-angle-right"></span> Third level</label>
              <ul class="sub-sub-group-list">
                <li><a href="#">3rd level nav item</a></li>
                <li><a href="#">3rd level nav item</a></li>
                <li><a href="#">3rd level nav item</a></li>
              </ul>
            </li>
          </ul>
        </li>
      </ul>
    </li>
    <li>
      <input id="group-2" type="checkbox" hidden />
      <label for="group-2"><span class="fa fa-angle-right"></span> First level</label>
      <ul class="group-list">
        <li><a href="#">1st level item</a></li>
        <li><a href="#">1st level item</a></li>
        <input id="sub-group-2" type="checkbox" hidden />
        <label for="sub-group-2"><span class="fa fa-angle-right"></span> Second level</label>
        <ul class="sub-group-list">
          <li><a href="#">2nd level nav item</a></li>
          <li><a href="#">2nd level nav item</a></li>
          <li>
            <input id="sub-sub-group-2" type="checkbox" hidden />
            <label for="sub-sub-group-2"><span class="fa fa-angle-right"></span> Third level</label>
            <ul class="sub-sub-group-list">
              <li><a href="#">3rd level nav item</a></li>
            </ul>
          </li>
        </ul>
      </ul>
    </li>
    <li>
      <input id="group-3" type="checkbox" hidden />
      <label for="group-3"><span class="fa fa-angle-right"></span> First level</label>
      <ul class="group-list">
        <li><a href="#">1st level item</a></li>
        <li><a href="#">1st level item</a></li>
        <input id="sub-group-3" type="checkbox" hidden />
        <label for="sub-group-3"><span class="fa fa-angle-right"></span> Second level</label>
        <ul class="sub-group-list">
          <li><a href="#">2nd level nav item</a></li>
          <li><a href="#">2nd level nav item</a></li>
          <li><a href="#">2nd level nav item</a></li>
          <li>
            <input id="sub-sub-group-3" type="checkbox" hidden />
            <label for="sub-sub-group-3"><span class="fa fa-angle-right"></span> Third level</label>
            <ul class="sub-sub-group-list">
              <li><a href="#">3rd level nav item</a></li>
              <li><a href="#">3rd level nav item</a></li>
              <li><a href="#">3rd level nav item</a></li>
            </ul>
          </li>
        </ul>
      </ul>
    </li>
    <li>
      <input id="group-4" type="checkbox" hidden />
      <label for="group-4"><span class="fa fa-angle-right"></span> First level</label>
      <ul class="group-list">
        <li><a href="#">1st level item</a></li>
        <input id="sub-group-4" type="checkbox" hidden />
        <label for="sub-group-4"><span class="fa fa-angle-right"></span> Second level</label>
        <ul class="sub-group-list">
          <li><a href="#">2nd level nav item</a></li>
          <li><a href="#">2nd level nav item</a></li>
        </ul>
      </ul>
    </li>
  </ul>
</nav>
</body>
</html>
