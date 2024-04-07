# feature_CrickBuzz
Steps to Run application:
1) clone each file and import maven import
2) open mysql work bench add below commands:
     i) create Schema named "crickbuzz_platform"
     ii) Kindly replace spring.datasource.url=jdbc:mysql://localhost:3306/crickbuzz_platform : with your port number
     dml:

         i) CREATE SCHEMA `crickbuzz_platform` ;
         ii) All tables will Automatically  created so no need to create table explicitly
         iii) Kindly Add dummy data to tables.
         NOte : username should be used as "userName".

3) Run All the Services
     i) CRICKBUZZ-SERVICE : port 8081
     ii)AUTHENTICATION-SERVICE: 8082
     iii)API-GATEWAY:8083
     iv) SERVICE-REGISTRY: 8761

4) After all service starts:
    i) hit request on http://localhost:8083

   end points:

   i) http://localhost:8083/api/admin/signup  [post] admin
   ii)http://localhost:8083/api/admin/login   [post] admin
   iii) http://localhost:8083/api/matches  [POST]   admin
   iv) http://localhost:8083/api/matches  [GET]  user
  
  v) http://localhost:8083/api/matches/{match_id}   -user
  vi) http://localhost:8083/api/teams/{team_id}/squad   -[post] admin
  vii) http://localhost:8083/api/players/{player_id}/stats   - user



   
     
