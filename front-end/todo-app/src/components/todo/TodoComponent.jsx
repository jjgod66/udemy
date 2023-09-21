import { useParams } from "react-router-dom";
import { retrieveTodoApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useEffect, useState } from "react";
import { Formik } from "formik";

function TodoComponent () {

    const {id} = useParams();

    const [description, setDescription] = useState();

    const authContext = useAuth();
    const username = authContext.username;

    useEffect(
        () => retrieveTodos(), [id]
    )

    function retrieveTodos() {
        retrieveTodoApi(username, id)
             .then(res => {
                setDescription(res.data.description);
            })
            .catch(err => console.log(err));
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                <Formik></Formik>
            </div>
        </div>
    )
}

export default TodoComponent;