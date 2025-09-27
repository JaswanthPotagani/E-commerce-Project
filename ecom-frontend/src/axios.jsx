import axios from "axios";

   const API = axios.create({
     baseURL: "/api", // Changed from "http://localhost:8080/api" 
   });
   delete API.defaults.headers.common["Authorization"];
   export default API;