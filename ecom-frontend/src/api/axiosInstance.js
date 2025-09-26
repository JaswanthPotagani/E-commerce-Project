import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080", // backend base url
});

// ✅ Use axiosInstance here (not api)
axiosInstance.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("jwtToken"); // store token after login
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

export default axiosInstance;
