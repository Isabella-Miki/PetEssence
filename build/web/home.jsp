<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>


<div class="main-wrapper" style="display:flex; justify-content: center; align-items: center; height: 100vh; flex-direction: column; position: relative;">
  <h1 class="text-center" style="position: absolute; top: 20px; width: 100%; text-align: center;">
      PetEssence
  </h1>
  
  <div class="image-wrapper" style="text-align: center;">
      <img src="https://i.imgur.com/u81LFVn.png" alt="Logo da Pet Essence" style="max-width: 70%; height: auto;">
      
      <h5 style="margin-top: 20px; font-size: 1.6em; font-weight: bold;">
          Sistema de gerenciamento e gestão AgroPet
      </h5>
  </div>
</div>

<jsp:include page="footer.jsp"/>
