import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from './security/AuthContext';

function LoginComponent() {

    const [username, setUsername] = useState('in28minutes');
    const [password, setPassword] = useState('');
    const [showErrorMesasge, setShowErrorMesasge] = useState(false);

    const navigate = useNavigate();

    const authContext = useAuth();

    function handleUsernameChange(e) {
        setUsername(e.target.value);
    }
    function handlePasswordChange(e) {
        setPassword(e.target.value);
    }

    function handleSubmit() {
        if(authContext.login(username,password)) {
            navigate(`/welcome/${username}`);
        } else {
            setShowErrorMesasge(true);
        }
    }

    return (
        <div className="Login">
            <h1>Time to Login!</h1>
            {showErrorMesasge && <div className="errorMessage">Authentication Failed. Please check your credentials.</div>}
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>login</button>
                </div>
            </div>
        </div>
    )
}

export default LoginComponent;