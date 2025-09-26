import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const OAuth2Success = () => {
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch user info or token if your backend provides it
    // For now, just redirect to home after login
    console.log("OAuth2 login successful!");
    navigate("/");
  }, [navigate]);

  return <h2>Login successful! Redirecting...</h2>;
};

export default OAuth2Success;
