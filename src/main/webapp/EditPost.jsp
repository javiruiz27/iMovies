
	<c:if test='${empty sessionScope["Facebook-token"]}'>
	   <c:redirect url = "/AuthController/Facebook"/>
	</c:if>
	
	<h1>Publicar Post en Facebook</h1>
	<div class="container">
	
		<p class="message"></p>
				
		<form action="/facebookPostCreation" method="post">
			
			Mensaje: <textarea name="message"></textarea>
			<br>
			<div class="bottom_links">
				<button type="submit" class="button">Publicar en Facebook</button>
				<button type="button" onClick="javascript:window.location.href='index.jsp'" class="button">Cancel</button>
			</div>
		</form>
	</div>

