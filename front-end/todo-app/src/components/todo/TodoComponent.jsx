import { useNavigate, useParams } from "react-router-dom";
import { createTodoApi, retrieveTodoApi, updateTodoApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useEffect, useState } from "react";
import { Field, Formik, Form, ErrorMessage } from "formik";
import moment from "moment";

function TodoComponent () {

    const {id} = useParams();

    const [description, setDescription] = useState('');
    const [targetDate, setTargetDate] = useState('');

    const authContext = useAuth();
    const navigate = useNavigate();

    const username = authContext.username;
    console.log(new Date().toString());
    useEffect(
        () => retrieveTodos(), [id]
    )

    function retrieveTodos() {

        if (id != -1) {
            retrieveTodoApi(username, id)
            .then(res => {
                     setDescription(res.data.description);
                     setTargetDate(res.data.targetDate);
            })
            .catch(err => console.log(err));
        }
    }

    function onSubmit(values) {
        const todo = {
            id : id,
            username : username,
            description : values.description,
            targetDate : values.targetDate,
            done : false
        }

        if (id == -1) {
            createTodoApi(username, todo)
            .then(res => {
                navigate('/todos');
            })
            .catch(err => console.log(err));
        } else {
            updateTodoApi(username, id, todo)
            .then(res => {
                navigate('/todos');
            })
            .catch(err => console.log(err));
        }
    }

    function validate(values) {
        let errors = {
            // description : 'Enter a valid description',
            // targetDate : 'Enter a valid target Date'
        };

        if (values.description.length < 5) {
            errors.description = 'Enter at least 5 characters';
        }

        if (values.targetDate == null || values.targetDate == '' || moment(values.targetDate).isBefore()) {
            errors.targetDate = 'Enter a valid target date';
        }

        return errors;
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                <Formik initialValues={{ description, targetDate }}
                    enableReinitialize= {true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage 
                                    name="description"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <ErrorMessage 
                                    name="targetDate"
                                    component="div"
                                    className="alert alert-warning"
                                />

                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" className="form-control" name="description" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field type="date" className="form-control" name="targetDate" />
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}

export default TodoComponent;