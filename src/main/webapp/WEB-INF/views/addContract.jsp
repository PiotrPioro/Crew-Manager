<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dodaj kontrakt</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/css/sb-admin-2.css"/>" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <%--<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>--%>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4"></h1>
                        </div>
                        <form:form action="/contract/addContract" method="post" modelAttribute="contract">

                            <div class="text">
                                Nazwa kontraktu:<form:input path="name" placeholder="Wpisz nazwę kontraktu"/><br>
                                <form:errors path="name"/><br>
                            </div>

                            <div class="text">
                                Miejsce kontraktu:<form:input path="place" placeholder="Wpisz miejsce"/><br>
                                <form:errors path="place"/><br>
                            </div>

                            <div class="text">
                                Nazwa firmy:<form:input path="companyName" placeholder="Wpisz nazwę firmy"/><br>
                                <form:errors path="companyName"/><br>
                            </div>

                            <div class="text">
                                Imię i nazwisko osoby kontaktowej:<form:input path="contactName" placeholder="Podaj dane osoby kontaktowej"/><br>
                                <form:errors path="contactName"/><br>
                            </div>

                            <div class="text">
                                Telefon kontaktowy:<form:input path="contactPhoneNumber" placeholder="Podaj numer telefonu do kontaktu"/><br>
                                <form:errors path="contactPhoneNumber"/><br>
                            </div>

                            <div class="text">
                                Data początku kontraktu:<form:input path="startDate" type="text" placeholder="Podaj datę początku kontraktu"/><br>
                                <form:errors path="startDate"/><br>
                            </div>

                            <div class="text">
                                Data zakończenia kontraktu:<form:input path="endDate" type="text" placeholder="Podaj datę końca kontraktu"/><br>
                                <form:errors path="endDate"/><br>
                            </div>

                            <h3>Zaznacz umiejętności pracownika potrzebne na tym kontrakcie:</h3>

                            <div class="-box">
                                Rigging:<form:checkbox path="rigging"/><br>
                            </div>

                            <div class="-box">
                                Construction:<form:checkbox path="construction"/><br>
                            </div>

                            <div class="-box">
                                Lighting:<form:checkbox path="lighting"/><br>
                            </div>

                            <div class="-box">
                                Forklift:<form:checkbox path="forklift"/><br>
                            </div>

                            <div class="-box">
                                Cherrypicker:<form:checkbox path="cherrypicker"/><br>
                            </div>

                            <div class="-box">
                                Sound:<form:checkbox path="sound"/><br>
                            </div>

                            <div class="-box">
                                Multimedia:<form:checkbox path="multimedia"/><br>
                            </div>

                            <div class="text">
                                <input type="submit" value="Zapisz"><br>
                            </div>
                        </form:form>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/js/sb-admin-2.min.js"/>"></script>

<!-- Page level plugins -->
<script src="<c:url value="/vendor/chart.js/Chart.min.js"/>"></script>

<!-- Page level custom scripts -->
<script src="<c:url value="/js/demo/chart-area-demo.js"/>"></script>
<script src="<c:url value="/js/demo/chart-pie-demo.js"/>"></script>

</body>

</html>