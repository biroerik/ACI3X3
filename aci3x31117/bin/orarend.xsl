<?xml version = "1.0" encoding = "UTF-8"?>

<xsl:stylesheet version = "1.0">   

   <xsl:template match = "/"> 
      
		
      <html> 
         <body> 
            <h2>employee</h2> 
				
            <table border = "1"> 
               <tr bgcolor = "#9acd32"> 
                  <th>id</th> 
                  <th>targy</th> 
                  <th>nap</th> 
                  <th>tol</th> 
                  <th>ig</th>
                  <th>helyszin</th>     
                  <th>oktato</th>   
                  <th>szak</th>           
               </tr> 
				
               
				
               <xsl:for-each select="orarend/ora"> 
                  <tr> 
                     <td> 
                       
                        <xsl:value-of select = "@id"/> 
                     </td> 
						
                     <td><xsl:value-of select = "targy"/></td> 
                     <td><xsl:value-of select = "nap"/></td> 
                     <td><xsl:value-of select = "tol"/></td> 
                     <td><xsl:value-of select = "ig"/></td> 
                     <td><xsl:value-of select = "helyszin"/></td>
                     <td><xsl:value-of select = "oktato"/></td>
                     <td><xsl:value-of select = "szak"/></td>
						
                  </tr> 
               </xsl:for-each> 
					
            </table> 
         </body> 
      </html> 
   </xsl:template>  
</xsl:stylesheet>