                         <%
                         String activeParam = "";
                        	activeParam =request.getParameter("active");
                        %>
                        
                        
                        
                <div class="cell size-x300" id="cell-sidebar" style="background-color: #71b1d1; height: 100%">
                    <ul class="sidebar">
                        <li><a href="#">
                            <span ></span>
                            <span class="fg-white1"></span>
                            </a>
                        </li>
                        <% if(activeParam.equals("inbox")){%> <li class="active"> <% }else{ %><li> <% } %><a href="_0_admin-sidebar-inbox.jsp">
                            <span class="mif-mail icon"></span>
                            <span class="fg-white1">Inbox</span>
                        </a></li>
						<hr class="thin" />
						
                       <% if(activeParam.equals("mydocs")){%> <li class="active"> <% }else{ %><li> <% } %><a href="_02_admin-sidebar-my-docs.jsp">
                            <span class="mif-search icon"></span>
                            <span class="fg-white1">My Documents</span>
                        </a></li>
                        						
	<hr class="thin" />
                        
                        <% if(activeParam.equals("project")){%> <li class="active"> <% }else{ %><li> <% } %><a href="_02_admin-sidebar-project-search.jsp">
                            <span class="mif-zoom-in icon"></span>
                            <span class="fg-white1">Project Search</span>
                        </a></li>
                        <% if(activeParam.equals("keyword")){%> <li class="active"> <% }else{ %><li> <% } %><a href="_03_admin-sidebar-keyword-search.jsp">
                            <span class="mif-cog icon"></span>
                            <span class="fg-white1">Keyword & Text Search</span>

                        </a></li>
                        <% if(activeParam.equals("metadata")){%> <li class="active"> <% }else{ %><li> <% } %><a href="_03_admin-sidebar-metadata-search.jsp">
                            <span class="mif-cog icon"></span>
                            <span class="fg-white1">Metadata Search</span>

                        </a></li>                        
                        <hr class="thin"/>
					
                        


                       
                        <% if(activeParam.equals("contupload")){%> <li class="active"> <% }else{ %><li> <% } %><a href="_08_admin-sidebar-content-upload.jsp">
                            <span class="mif-file-upload icon"></span>
                            <span class="fg-white1">Content Upload</span>
                        </a></li>
                        <hr class="thin" />
                        <% if(activeParam.equals("purl")){%> <li class="active"> <% }else{ %><li> <% } %><a href="_09_admin-sidebar-purl.jsp">
                            <span class="mif-link icon "></span>
                            <span class="fg-white1">P-URL Management</span>
                        </a></li>                        
                    </ul>
                </div>