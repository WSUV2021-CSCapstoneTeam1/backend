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
<h3>cs420 Capstone - Backend API Documentation</h3>
<p>Base URL: <a href="/BackendApi-1.0-SNAPSHOT/">https://hp.wsuv-cs-project.com:8443/BackendApi-1.0-SNAPSHOT/</a></p>
<p>SiteFlow API link: <a href="https://docs.oneflowcloud.com/api-reference/siteflow/" target="_blank">https://docs.oneflowcloud.com/api-reference/siteflow/</a></p>
<nav class="nav" role="navigation">
  <ul class="nav__list">
    <li>
      <input id="group-0" type="checkbox" hidden />
      <label for="group-0"><span class="fa fa-angle-right"></span> Server</label>
      <ul class="group-list">
        <li>
          <br/>
          <table id="server-info-table">
          <tr><td>Server</td><td>Amazon EC2 t2.medium</td></tr>
          <tr><td>Operating System - Platform</td><td>Amazon  Linux, Linux 2 (AMI)</td></tr>
          <tr><td>Web Server</td><td>Tomcat 9.x</td></tr>
          <tr><td>Application</td><td>Java Enterprise Edition (EE)</td></tr>
          <tr><td>Endpoint API</td><td>JAX rs - Jersey dependency</td></tr>
          <tr><td>Credentials</td><td>AWS Secrets Manager</td></tr>
          <tr><td>Database</td><td>MySQL RDS - endpoint</td></tr>
        </table>
          <br/>
        </li>
      </ul>
    </li>
    <li>
      <input id="group-1" type="checkbox" hidden />
      <label for="group-1"><span class="fa fa-angle-right"></span> CI/CD</label>
      <ul class="group-list">
        <li>
          <br/>
          <table id="cicd-info-table">
            <tr><td>CI/CD Server Application</td><td>Jenkins and Git</td></tr>
            <tr><td>Connected to:</td><td>Github Repository</td></tr>
            <tr><td>Connected with:</td><td>Github webhooks</td></tr>
          </table>
          <br/>
        </li>
      </ul>
    </li>

    <li>
      <input id="group-2" type="checkbox" hidden />
      <label for="group-2"><span class="fa fa-angle-right"></span> Backend API</label>
      <ul class="group-list">

        <li>
          <input id="sub-group-2-order" type="checkbox" hidden />
          <label for="sub-group-2-order"><span class="fa fa-angle-right"></span> Order</label>
          <ul class="sub-group-list">
            <li>
              <input id="sub-group-2-6" type="checkbox" hidden />
              <label for="sub-group-2-6"><span class="fa fa-angle-right"></span> Connect to HP Siteflow Endpoint </label>
              <ul class="sub-group-list">
                <li>
                  <input id="sub-group-2-6-1" type="checkbox" hidden />
                  <label for="sub-group-2-6-1"><span class="fa fa-angle-right"></span> GET - api/order/siteflow/get/all </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/order/siteflow/get/all</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Header</td><td>siteflow-organization</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-sku-siteflow-get-all.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-6-4" type="checkbox" hidden />
                  <label for="sub-group-2-6-4"><span class="fa fa-angle-right"></span> GET - api/order/siteflow/get?id=[orderID] </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/order/siteflow/get?id=[orderID]</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Header</td><td>siteflow-organization</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-sku-siteflow-get-all.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-6-3" type="checkbox" hidden />
                  <label for="sub-group-2-6-3"><span class="fa fa-angle-right"></span> POST - api/order/siteflow/post </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/order/siteflow/post</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>POST</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>201 OK</td></tr>
                        <tr><td class="api-doc-field-name">Input</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Input Format</td><td><img src="img/doc-sku-siteflow-post-json.png" /></td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">201 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-sku-siteflow-post.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
              </ul>
            </li>
          </ul>
        </li>
        <li>
          <input id="sub-group-2-prod" type="checkbox" hidden />
          <label for="sub-group-2-prod"><span class="fa fa-angle-right"></span> Product</label>
          <ul class="sub-group-list">
            <li>
              <input id="sub-group-2-3" type="checkbox" hidden />
              <label for="sub-group-2-3"><span class="fa fa-angle-right"></span> Connect to HP Siteflow Endpoint </label>
              <ul class="sub-group-list">
                <li>
                  <input id="sub-group-2-3-1" type="checkbox" hidden />
                  <label for="sub-group-2-3-1"><span class="fa fa-angle-right"></span> GET - api/product/siteflow/get/all </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/product/siteflow/get/all</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Header</td><td>siteflow-organization</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-product-siteflow-get-all.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
              </ul>
            </li>
          </ul>
        </li>




        <!--- START COPY --->


        <li>
          <input id="sub-group-2-sku" type="checkbox" hidden />
          <label for="sub-group-2-sku"><span class="fa fa-angle-right"></span> SKU</label>
          <ul class="sub-group-list">
            <li>
              <input id="sub-group-2-4" type="checkbox" hidden />
              <label for="sub-group-2-4"><span class="fa fa-angle-right"></span> Connect to HP Siteflow Endpoint </label>
              <ul class="sub-group-list">
                <li>
                  <input id="sub-group-2-4-1" type="checkbox" hidden />
                  <label for="sub-group-2-4-1"><span class="fa fa-angle-right"></span> GET - api/sku/siteflow/get/all </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/sku/siteflow/get/all</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Header</td><td>siteflow-organization</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-sku-siteflow-get-all.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-4-3" type="checkbox" hidden />
                  <label for="sub-group-2-4-3"><span class="fa fa-angle-right"></span> POST - api/sku/siteflow/post </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/sku/siteflow/post</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>POST</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>201 OK</td></tr>
                        <tr><td class="api-doc-field-name">Input</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Input Format</td><td><img src="img/doc-sku-siteflow-post-json.png" /></td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">201 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-sku-siteflow-post.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
              </ul>
            </li>
            <!---
            <li>
              <input id="sub-group-2-2" type="checkbox" hidden />
              <label for="sub-group-2-2"><span class="fa fa-angle-right"></span> Connect to MySQL RDS Endpoint </label>
              <ul class="sub-group-list">
                <li>
                  <input id="sub-group-2-2-1" type="checkbox" hidden />
                  <label for="sub-group-2-2-1"><span class="fa fa-angle-right"></span> GET - api/template/rds/get/all </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/get/all</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-get-all.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-2-2" type="checkbox" hidden />
                  <label for="sub-group-2-2-2"><span class="fa fa-angle-right"></span> GET - api/template/rds/get?id=[integer] </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/get?id=[integer]</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-get-by-id.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-2-3" type="checkbox" hidden />
                  <label for="sub-group-2-2-3"><span class="fa fa-angle-right"></span> POST - api/template/rds/post </label>
                  <ul class="sub-group-list">
                    <li>

                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/post</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>POST</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                        <tr><td class="api-doc-field-name">Input</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Input Format</td><td><img src="img/doc-template-rds-post-json.png" /></td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-post-new.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                --->
            <!---
                <li>
                  <input id="sub-group-2-2-5" type="checkbox" hidden />
                  <label for="sub-group-2-2-5"><span class="fa fa-angle-right"></span> DELETE - api/template/rds/delete?id=[integer] </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/delete?id=[integer]</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>DELETE</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK, 204 No Content</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-delete-by-id.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
              </ul>
            </li>
        --->
          </ul>
        </li>



        <!--- END COPY --->



        <!--- START TEAM --->

        <li>
          <input id="sub-group-2-team" type="checkbox" hidden />
          <label for="sub-group-2-team"><span class="fa fa-angle-right"></span> Team</label>
          <ul class="sub-group-list">
            <!---
            <li>
              <input id="sub-group-2-5" type="checkbox" hidden />
              <label for="sub-group-2-5"><span class="fa fa-angle-right"></span> Connect to HP Siteflow Endpoint </label>
              <ul class="sub-group-list">
                <li>
                  <input id="sub-group-2-5-1" type="checkbox" hidden />
                  <label for="sub-group-2-5-1"><span class="fa fa-angle-right"></span> GET - api/sku/siteflow/get/all </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/sku/siteflow/get/all</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-sku-siteflow-get-all.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
              </ul>
            </li>
            --->
            <li>
              <input id="sub-group-2-5" type="checkbox" hidden />
              <label for="sub-group-2-5"><span class="fa fa-angle-right"></span> Connect to MySQL RDS Endpoint </label>
              <ul class="sub-group-list">
                <li>
                  <input id="sub-group-2-5-1" type="checkbox" hidden />
                  <label for="sub-group-2-5-1"><span class="fa fa-angle-right"></span> GET - api/team/rds/get/all </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/team/rds/get/all</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-team-rds-get-all.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <!---
                <li>
                  <input id="sub-group-2-2-2" type="checkbox" hidden />
                  <label for="sub-group-2-2-2"><span class="fa fa-angle-right"></span> GET - api/template/rds/get?id=[integer] </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/get?id=[integer]</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-get-by-id.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-2-3" type="checkbox" hidden />
                  <label for="sub-group-2-2-3"><span class="fa fa-angle-right"></span> POST - api/template/rds/post </label>
                  <ul class="sub-group-list">
                    <li>

                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/post</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>POST</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                        <tr><td class="api-doc-field-name">Input</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Input Format</td><td><img src="img/doc-template-rds-post-json.png" /></td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-post-new.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-2-4" type="checkbox" hidden />
                  <label for="sub-group-2-2-4"><span class="fa fa-angle-right"></span> POST - api/template/rds/update?id=[integer] </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/update?id=[integer]</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>POST</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                        <tr><td class="api-doc-field-name">Input</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Input Format</td><td><img src="img/doc-template-rds-post-json.png" /></td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-update-by-id.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-2-5" type="checkbox" hidden />
                  <label for="sub-group-2-2-5"><span class="fa fa-angle-right"></span> DELETE - api/template/rds/delete?id=[integer] </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/delete?id=[integer]</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>DELETE</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK, 204 No Content</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-delete-by-id.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
        --->
              </ul>
            </li>
          </ul>
        </li>



        <!--- END TEAM --->


        <!--- START TEMPLATE --->

        <li>
          <input id="sub-group-2" type="checkbox" hidden />
          <label for="sub-group-2"><span class="fa fa-angle-right"></span> Template</label>
          <ul class="sub-group-list">
            <li>
              <input id="sub-group-2-1" type="checkbox" hidden />
              <label for="sub-group-2-1"><span class="fa fa-angle-right"></span> Connect to HP Siteflow Endpoint </label>
              <ul class="sub-group-list">
                <li>
                  <input id="sub-group-2-1-1" type="checkbox" hidden />
                  <label for="sub-group-2-1-1"><span class="fa fa-angle-right"></span> GET - api/template/siteflow/get/all </label>
                    <ul class="sub-group-list">
                      <li>
                        <br/>

                        <table class="api-doc-table">
                          <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/siteflow/get/all</td></tr>
                          <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                          <tr><td class="api-doc-field-name">Header</td><td>siteflow-organization</td></tr>
                          <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                          <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                        </table>

                        <table class="postman-example">
                          <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                          <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-siteflow-get-all.png" /></td></tr>
                        </table>

                      </li>
                    </ul>
                </li>
              </ul>
            </li>
            <li>
              <input id="sub-group-2-2" type="checkbox" hidden />
              <label for="sub-group-2-2"><span class="fa fa-angle-right"></span> Connect to MySQL RDS Endpoint </label>
              <ul class="sub-group-list">
                <li>
                  <input id="sub-group-2-2-1" type="checkbox" hidden />
                  <label for="sub-group-2-2-1"><span class="fa fa-angle-right"></span> GET - api/template/rds/get/all </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/get/all</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-get-all.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-2-2" type="checkbox" hidden />
                  <label for="sub-group-2-2-2"><span class="fa fa-angle-right"></span> GET - api/template/rds/get?id=[integer] </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/get?id=[integer]</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>GET</td></tr>
                        <tr><td class="api-doc-field-name">Returns</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-get-by-id.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-2-3" type="checkbox" hidden />
                  <label for="sub-group-2-2-3"><span class="fa fa-angle-right"></span> POST - api/template/rds/post </label>
                  <ul class="sub-group-list">
                    <li>

                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/post</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>POST</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                        <tr><td class="api-doc-field-name">Input</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Input Format</td><td><img src="img/doc-template-rds-post-json.png" /></td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-post-new.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-2-4" type="checkbox" hidden />
                  <label for="sub-group-2-2-4"><span class="fa fa-angle-right"></span> PUT - api/template/rds/update?id=[integer] </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/update?id=[integer]</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>PUT</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK</td></tr>
                        <tr><td class="api-doc-field-name">Input</td><td>JSON Object</td></tr>
                        <tr><td class="api-doc-field-name">Input Format</td><td><img src="img/doc-template-rds-post-json.png" /></td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-update-by-id.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
                <li>
                  <input id="sub-group-2-2-5" type="checkbox" hidden />
                  <label for="sub-group-2-2-5"><span class="fa fa-angle-right"></span> DELETE - api/template/rds/delete?id=[integer] </label>
                  <ul class="sub-group-list">
                    <li>
                      <br/>

                      <table class="api-doc-table">
                        <tr><td class="api-doc-field-name">Endpoint URL</td><td>api/template/rds/delete?id=[integer]</td></tr>
                        <tr><td class="api-doc-field-name">Method</td><td>DELETE</td></tr>
                        <tr><td class="api-doc-field-name">Postbacks</td><td>200 OK, 204 No Content</td></tr>
                      </table>

                      <table class="postman-example">
                        <tr><td class="api-doc-field-postman-title">POSTMAN EXAMPLE</td><td class="api-doc-field-postman-postback">200 OK</td></tr>
                        <tr><td></td>><td class="api-doc-field-image"><img src="img/doc-template-rds-delete-by-id.png" /></td></tr>
                      </table>

                    </li>
                  </ul>
                </li>
              </ul>
            </li>
          </ul>
        </li>
        <!--- END TEMPLATE --->

      </ul>
    </li>
  </ul>
</nav>
</body>
</html>
