import './App.css'
import DepartmentComponent from './components/DepartmentComponent'
import EmployeeComponent from './components/EmployeeComponent'
import FooterComponents from './components/FooterComponents'
import HeaderComponet from './components/HeaderComponet'
import ListDepartmentComponent from './components/ListDepartmentComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'

function App() {

  return (
    <>
    <BrowserRouter>
      <HeaderComponet/>
      <Routes>
        {/* //http://;ocalhost:3001 */}
          <Route path='/' element = { <ListEmployeeComponent/>}></Route>
          {/* //http://localhost:3001/employees */}
          <Route path='/employees' element = { <ListEmployeeComponent/> }></Route>
          {/* //http://localhost:3001/add-employee */}
          <Route path='/add-employee' element = { <EmployeeComponent/>}></Route>
          {/* //http://localhost:3001/edit-employee1 */}
          <Route path='/edit-employee/:id' element = {<EmployeeComponent/>}></Route>

          {/* //http://localhost:3001/departments */}
          <Route path='/departments' element = { <ListDepartmentComponent/>}></Route>

          {/* //http://localhost:3001/add-departments */}
          <Route path='/add-department' element = { <DepartmentComponent/>}></Route>
          <Route path='/edit-department/:id' element = { <DepartmentComponent/>}></Route>
      </Routes>
      <FooterComponents/>
    </BrowserRouter>
    </>
  )
}

export default App

// well in order to configure the routing we have to use routing related components from rEACT ROUTER DOM LIBARAY
