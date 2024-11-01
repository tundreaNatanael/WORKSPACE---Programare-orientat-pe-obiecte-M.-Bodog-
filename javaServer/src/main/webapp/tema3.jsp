<!DOCTYPE html>
<html>

	<head></head>
	
	<body>
	
		<h1>Rezultate</h1>
		
		
		<div>
    		Suma: <b><%= Integer.parseInt(request.getParameter("nr1")) + Integer.parseInt(request.getParameter("nr2")) %></b>
		</div>

		<div>
    		par sau impar: <b><%= Integer.parseInt(request.getParameter("par")) % 2 == 0 ? "par" : "impar" %></b>
		</div>
		
		<div>
			<%
        		String text = request.getParameter("text");

        		int vowelCount = 0;
        		text = text.toLowerCase();
        		for (int i = 0; i < text.length(); i++) {
            		char c = text.charAt(i);
            		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                		vowelCount++;
            		}
        		}
    		%>
    			Nr de vocale: <b><%= vowelCount %></b>
			</div>
		</div>
	</body>

</html>