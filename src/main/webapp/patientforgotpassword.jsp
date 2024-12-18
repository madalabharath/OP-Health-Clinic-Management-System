<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: #f0f4f7;
            overflow: hidden;
            position: relative;
        }
        .forgot-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
            z-index: 10;
            position: relative;
        }
        .forgot-container h2 {
            margin-bottom: 30px;
            color: #00796b;
            font-size: 24px;
        }
        .forgot-container form {
            display: flex;
            flex-direction: column;
        }
        .forgot-container label {
            margin-bottom: 10px;
            text-align: left;
            color: #555;
            font-size: 14px;
        }
        .forgot-container input {
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        .forgot-container button {
            padding: 12px;
            background-color: #00796b;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .forgot-container button:hover {
            background-color: #004d40;
        }
        /* Additional styles for responsiveness */
        @media (max-width: 600px) {
            .forgot-container {
                padding: 20px;
            }
        }

        /* Styles for particle background */
        #particles-js {
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            z-index: 0;
        }

        /* Error message styles */
        .error-message {
            color: #d32f2f;
            font-size: 14px;
            margin-top: -15px;
            margin-bottom: 20px;
            text-align: left;
        }
    </style>
</head>
<body>
    <div id="particles-js"></div>
    <div class="forgot-container">
        <h2>Forgot Password</h2>
        <form id="resetForm" action="ForgotPassword" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required>
            <div id="error-message" class="error-message"></div>
            <button type="submit">Reset Password</button>
        </form>
    </div>

    <!-- Include particles.js -->
    <script src="https://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js"></script>
    <script>
        particlesJS("particles-js", {
            "particles": {
                "number": {
                    "value": 100,
                    "density": {
                        "enable": true,
                        "value_area": 800
                    }
                },
                "color": {
                    "value": "#00796b"
                },
                "shape": {
                    "type": "circle",
                    "stroke": {
                        "width": 0,
                        "color": "#000000"
                    },
                    "polygon": {
                        "nb_sides": 5
                    },
                    "image": {
                        "src": "img/github.svg",
                        "width": 100,
                        "height": 100
                    }
                },
                "opacity": {
                    "value": 0.5,
                    "random": false,
                    "anim": {
                        "enable": false,
                        "speed": 1,
                        "opacity_min": 0.1,
                        "sync": false
                    }
                },
                "size": {
                    "value": 3,
                    "random": true,
                    "anim": {
                        "enable": false,
                        "speed": 40,
                        "size_min": 0.1,
                        "sync": false
                    }
                },
                "line_linked": {
                    "enable": true,
                    "distance": 150,
                    "color": "#00796b",
                    "opacity": 0.4,
                    "width": 1
                },
                "move": {
                    "enable": true,
                    "speed": 6,
                    "direction": "none",
                    "random": false,
                    "straight": false,
                    "out_mode": "out",
                    "bounce": false,
                    "attract": {
                        "enable": false,
                        "rotateX": 600,
                        "rotateY": 1200
                    }
                }
            },
            "interactivity": {
                "detect_on": "canvas",
                "events": {
                    "onhover": {
                        "enable": true,
                        "mode": "repulse"
                    },
                    "onclick": {
                        "enable": true,
                        "mode": "push"
                    },
                    "resize": true
                },
                "modes": {
                    "grab": {
                        "distance": 400,
                        "line_linked": {
                            "opacity": 1
                        }
                    },
                    "bubble": {
                        "distance": 400,
                        "size": 40,
                        "duration": 2,
                        "opacity": 8,
                        "speed": 3
                    },
                    "repulse": {
                        "distance": 200,
                        "duration": 0.4
                    },
                    "push": {
                        "particles_nb": 4
                    },
                    "remove": {
                        "particles_nb": 2
                    }
                }
            },
            "retina_detect": true
        });

        // Client-side validation
        document.addEventListener("DOMContentLoaded", function() {
            const form = document.getElementById("resetForm");
            const passwordInput = document.getElementById("newPassword");
            const errorMessage = document.getElementById("error-message");

            form.addEventListener("submit", function(event) {
                const password = passwordInput.value;
                const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

                if (!passwordRegex.test(password)) {
                    errorMessage.textContent = "Password must be at least 8 characters long and contain letters, numbers, and symbols.";
                    event.preventDefault(); // Prevent form submission
                } else {
                    errorMessage.textContent = ""; // Clear any previous error message
                }
            });
        });
    </script>
</body>
</html>
