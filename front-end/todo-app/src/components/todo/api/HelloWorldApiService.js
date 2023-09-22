import {apiClient} from './ApiClient';

export const retrieveHelloWorldBean 
    = () => apiClient.get('/hello-world-bean');

//Response to preflight request doesn't pass access control check => Authorization Header
export const retrieveHelloWorldPathVariable
    = (username, token) => apiClient.get(`/hello-world/path-variable/${username}`);
