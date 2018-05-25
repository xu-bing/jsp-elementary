	var xmlHttpRequest = null;
  	
  	function getXmlHttpRequest(){
  	
  		try{
  			
  			xmlHttpRequest = new XMLHttpRequest();
  			
  		}catch(e){
  		
  			try{
  				
  				xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
  			}catch(e){
  			
  				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
  			
  			}
  		
  		}
  
  	}