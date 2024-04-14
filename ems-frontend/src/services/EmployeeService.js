import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/employees";

export const listEmployees = () => axios.get(REST_API_BASE_URL);

// now write the ReST client code to make A rest api call  change listEmployeecomponets

export const createEmployee = (employee) =>
  axios.post(REST_API_BASE_URL, employee);

export const getEmployee = (employeeId) =>
  axios.get(REST_API_BASE_URL + "/" + employeeId);

export const updateEmployee = (employeeId, employee) =>
  axios.put(REST_API_BASE_URL + "/" + employeeId, employee);

export const deleteEmployee = (employeeId) =>
  axios.delete(REST_API_BASE_URL + "/" + employeeId);
