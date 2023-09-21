import { Link, useParams } from 'react-router-dom';
import { useState } from 'react';
import { retrieveHelloWorldPathVariable } from './api/HelloWorldApiService';

function WelcomeComponent() {

    const {username} = useParams();

    const [message, setMessage] = useState(null);

    function callHelloWorldRestApi() {
        console.log('called');

        retrieveHelloWorldPathVariable('username')
            .then((res) => successfulResponse(res))
            .catch((err) => errorResponse(err))
            .finally(() => console.log('clean up'));
    }

    function successfulResponse(res) {
        console.log(res);
        setMessage(res.data.message);
    }
    function errorResponse(err) {
        console.log(err);
    }

    return (
        <div className='WelcomeComponent'>
            <h1>Welcome {username}</h1>
            <div>
                Manage Your todos - <Link to='/todos'>Go Here</Link>
            </div>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>
                    Call Hello World
                </button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}

export default WelcomeComponent;