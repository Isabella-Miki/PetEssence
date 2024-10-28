<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>PetEssence</title>
        <!-- JQuery -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.mask.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.maskMoney.min.js"></script>

        <!-- Importação da minha biblioteca de javascript -->
        <script src="${pageContext.request.contextPath}/js/app.js" type="text/javascript"></script>

        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <!-- Datatable -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>

        <!-- Mensagem alerta -->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.3.1/dist/sweetalert2.all.min.js" type="text/javascript">
        </script>

        <style>
            body {
                display: grid;
                grid-template-columns: 0.15fr 1fr;
                grid-template-rows: 0.10fr 1fr 0.1fr;
                grid-template-areas: 
                    "navbar navbar"
                    "sidebar main"
                    "footer footer";
                min-height: 100vh;
                min-width: 100vw;
            }
            
            footer {
                background-color: #29C28D;
                grid-area: footer;
            }
            
            .main-wrapper {
                min-height: 100vh;
                grid-area: main;
            }
            
            .sidebar {
                grid-area: sidebar;
            }

            .btn-primary, .btn-primary:hover, .btn-primary:active, .btn-primary:visited {
                background-color: #29C28D !important;
                border-color: #29C28D;
                transition: none;
                color: #fff;
            }

            .navbar {
                color: #fff !important;
                background-color: #29C28D !important;
                grid-area: navbar;
            }
            
            .dataTables_filter input {
                border-radius: 4px;
                border: 1px solid #4a4a4a;
                padding: 5px 8px;
                width: 210px;
                background-color: #f8f9fa;
            }
    
        </style>
    </head>
    <body>
