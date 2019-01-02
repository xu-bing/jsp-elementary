流程：
MVC



DAO

index ---> empServlet ---> empService
                              |
                            empServiceImpl ---> empDao
                                                   |
                                                 empDaoImpl ---> db