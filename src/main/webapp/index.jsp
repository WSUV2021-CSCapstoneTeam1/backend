<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Capstone Backend API - Documentation</title>
    <style>
        div.typeApi {
            padding-left: 0.5em;
        }
        div.siteFlow {
            padding-left: 1em;
        }
        div.rds {
            padding-left: 1em;
        }
        div.getFunc {
            padding-left: 2em;
        }
        div.postFunc {
            padding-left: 2em;
        }
        div.info {
            padding-left: 3em;
        }
    </style>
</head>
<body>
<p><b>Capstone API Documentation:</b></p>
<div class="typeApi">
    <p><b>Template</b></p>
    <p><a href="https://docs.oneflowcloud.com/api-reference/siteflow/#/Template" target="_blank">HP SiteFlow API "Template" Documentation</a></p>

    <div class="siteFlow">
        <p><b>-> SiteFlow</b></p>

        <div class="getFunc">
            <p><a href="api/template/siteflow/get/all" target="_blank">GET - ALL - API - Templates (SiteFlow all)</a></p>
            <div class="info">
                <p>[IP Address]:8090/BackendApi-1.0-SNAPSHOT/api/template/siteflow/get/all</p>
                <p>POSTMAN Example:</p>
                <img src="img/doc-template-siteflow-get-all.png" width="45%" />
            </div>
        </div>
    </div>

    <div class="rds">
        <p><b>-> MySQL - RDS</b></p>
        <div class="getFunc">
            <p><a href="api/template/rds/get/all" target="_blank">GET - ALL - API - Templates (RDS all)</a></p>
            <div class="info">
                <p>[IP Address]:8090/BackendApi-1.0-SNAPSHOT/api/template/rds/get/all</p>
                <p>POSTMAN Example:</p>
                <img src="img/doc-template-rds-get-all.png" width="45%" />
            </div>
            <br />
            <p><a href="api/template/rds/get?id=2" target="_blank">GET - BY ID - API - Templates (RDS get by ID "2")</a></p>
            <div class="info">
                <p>[IP Address]:8090/BackendApi-1.0-SNAPSHOT/api/template/rds/get?id=2</p>
                <p>Input is an Integer appended to the end of the URL --> ../get?id=[Integer]</p>
                <p>POSTMAN Example:</p>
                <img src="img/doc-template-rds-get-by-id.png" width="45%" />
            </div>
        </div>
        <div class="postFunc">
            <p>POST - NEW TEMPLATE - API - Templates (RDS)</p>
            <div class="info">
                <p>[IP Address]:8090/BackendApi-1.0-SNAPSHOT/api/template/rds/post</p>
                <p>Input:<br />
                    JSON formatted object:<br />
                    <img src="img/doc-template-rds-post-json.png" width="40%" />
                </p>
                <p>POSTMAN Example:</p>
                <img src="img/doc-template-rds-post-new.png" width="45%" />
            </div>
            <br />
            <p>POST - UPDATE TEMPLATE BY ID - API - Templates (RDS update by ID "2")</p>
            <div class="info">
                <p>[IP Address]:8090/BackendApi-1.0-SNAPSHOT/api/template/rds/update?id=2</p>
                <p>Input:<br />
                    is an Integer appended to the end of the URL --> ../update?id=[Integer]<br />
                    JSON formatted object:<br />
                    <img src="img/doc-template-rds-post-json.png" width="40%" />
                </p>
                <p>POSTMAN Example:</p>
                <img src="img/doc-template-rds-update-by-id.png" width="45%" />
            </div>
        </div>
    </div>
</div>

</body>
</html>