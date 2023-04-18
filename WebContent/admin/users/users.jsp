<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col mt-4">
	<div class="b-b">
		<div class="nav-active-border b-primary bottom">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation"><a class="nav-link active" name="useredit" id="videoEdition-tab"
					data-toggle="tab" href="#videoEdition" role="tab" aria-controls="userEdition" aria-selected="true">USER EDITION</a></li>
				<li class="nav-item" role="presentation"><a class="nav-link" name="userlist" id="videoList-tab"
					data-toggle="tab" href="#videoList" role="tab" aria-controls="userList" aria-selected="false">USER LIST</a></li>
			</ul>
		</div>
	</div>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEdition" role="tabpanel" aria-labelledby="videoEdition-tab">
			<form action="" method="post">
				<div class="card">
					<div class="card-body">
						<jsp:include page="/common/inform.jsp"></jsp:include>
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label>Username</label> <input type="text" class="form-control" name="username" value="${user.id}"
										placeholder="Username">
								</div>
								<div class="form-group">
									<label>Fullname</label> <input type="text" class="form-control" name="fullname" value="${user.fullname}"
										placeholder="Fullname">
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label>Password</label> <input type="text" class="form-control" name="password" value="${user.password}"
										placeholder="Password">
								</div>
								<div class="form-group">
									<label>Email</label> <input type="text" class="form-control" name="email" value="${user.email}"
										placeholder="Email">
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button name="createuser" class="btn btn-outline-primary create" formaction="admin/users/create">Create</button>
						<button name="updateuser" class="btn btn-outline-success update" formaction="admin/users/update">Update</button>
						<button name="deleteuser" class="btn btn-outline-danger delete" formaction="admin/users/delete">Delete</button>
						<button name="resetuser" class="btn btn-outline-warning reset" formaction="admin/users/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel" aria-labelledby="videoList-tab">
			<table class="table table-bordered">
				<tr class="bg-success" style="color: blueviolet;">
					<th>Username</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Role</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="item" items="${users}">
					<tr style="color: green;">
						<td>${item.id}</td>
						<td>${item.fullname}</td>
						<td>${item.email}</td>
						<td>${item.admin? 'Admin' : 'User'}</td>
						<td><a href="admin/users/edit?username=${item.id}" class="btn btn-icon btn-white" name="edituser"><i
								data-feather="edit"></i></a> <a href="admin/users/delete?username=${item.id}" class="btn btn-icon btn-white"
							name="deluser"><i data-feather="x"></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>