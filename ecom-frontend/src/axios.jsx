// import axios from "axios";

// const API = axios.create({
//   baseURL: "http://localhost:8080/api",
// });
// delete API.defaults.headers.common["Authorization"];
// export default API;

import axios from "axios";

const API = axios.create({
  baseURL: "/api", // Changed from "http://localhost:8080/api" to "/api"
});
delete API.defaults.headers.common["Authorization"];
export default API;