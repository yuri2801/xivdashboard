<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>XIV DashBoard</title>
<meta charset="UTF-8" />
<c:url value="/resources" var="resources" />
<link rel="stylesheet" href="${resources }/css/bootstrap.min.css" />
<link rel="stylesheet" href="${resources }/css/gridstack/gridstack.css" />
<link rel="stylesheet" href="${resources }/css/gridstack/gridstack-extra.css" />
<link rel="stylesheet" href="${resources }/css/theme.css" />

<script src="${resources }/js/jquery.js"></script>
<script src="${resources }/js/jquery-ui/jquery-ui.js"></script>
<script src="${resources }/js/bootstrap.min.js"></script>
<script src="${resources }/js/lodash.js"></script>
<script src="${resources }/js/gridstack/gridstack.js"></script>
<script src="${resources }/js/angular.js"></script>
<script src="${resources }/js/angular-route.js"></script>
<script src="${resources }/js/gridstack-angular.js"></script>
<script src="${resources }/js/script.js"></script>
</head>
<body>
	<div class="container-fluid" ng-app="xivdashboard">
		<h1>Two grids demo</h1>

		<div class="row">
			<div class="grid-stack grid-stack-5" id="content"
				ng-controller="bodyCtrl">

			<div class="container-fluid">
				<h1>gridstack-angular demo</h1>
				<p>{{containers}}</p>
				<div>
					<a class="btn btn-primary" ng-click="addWidget()" href="#">Add
						Widget</a>
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<div gridstack class="grid-stack grid1" options="options"
							on-change="onChange(event,items)"
							on-drag-start="onDragStart(event,ui)"
							on-drag-stop="onDragStop(event,ui)"
							on-resize-start="onResizeStart(event,ui)"
							on-resize-stop="onResizeStop(event,ui)">
							<div gridstack-item ng-repeat="c in containers"
								class="grid-stack-item" gs-item-x="c.x" gs-item-y="c.y"
								gs-item-width="c.width" gs-item-height="c.height"
								gs-item-autopos="1" on-item-added="onItemAdded(item)"
								on-item-removed="onItemRemoved(item)">
								<div class="grid-stack-item-content">
									<div class="grid-stack-item-bar">
										{{c.name}}
										<div class="icons">
											<a ng-click="removeWidget(c)" href="#"><img class="settings-widget" src="${resources }/images/settings.svg" /></a>
											<a ng-click="removeWidget(c)" href="#"><img class="close-widget" src="${resources }/images/cancel.svg" /></a>
										</div>
									</div>

									<widget type="{{c.template}}">
									<div class="grid-stack-item-body">{{c.content}}</div>
									</widget>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>