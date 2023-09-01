import React, { useState } from 'react';
import axios  from 'axios';
import './EmployeeTable.css';

function EmployeeTable({ employees, selectedEmployees, handleCheckboxChange, handleSelectAllChange, selectAll }) {
  const [selectedEmployee, setSelectedEmployee] = useState(null);
  const [searchName, setSearchName] = useState('');
  const [cc, setCC] = useState(false);
  const [message, setMessage] = useState('');
  const [employeeSelected, setEmployeeSelected] = useState(null);
  const [nameSelected, setNameSelected] = useState(false); // New state to track whether a name has been selected

  const handleEmployeeSelect = (employee) => {
    setSelectedEmployee(employee);
    setEmployeeSelected(employee);
    setSearchName(employee.employeeName);
    setNameSelected(true); // Set nameSelected to true when a name is selected
    // console.log("employee",employee);
  };

  const sendEmail = () => {
    let obj = {
      to: selectedEmployee.employeeEmailId,
      empName: selectedEmployee.employeeName,
      isHtml: true,
      attendedList: selectedEmployee.attendedList,
      pendingList: selectedEmployee.pendingList,
    };

    if (cc) {
      obj.cc = [selectedEmployee.reportingEmailId];
    }

    if (message !== '') {
      obj.message = message;
    }

    //console.log(obj)

    axios.post('http://localhost:8084/api/v1/send-mail-notification/sendmail', obj) // Replace '/api/send-email' with your actual backend API endpoint
    .then(response => {
      console.log('Email sent successfully:', response.obj);
      // You can perform any further actions here after successful email sending
      alert("Email sent successfully");
    })
    .catch(error => {
      console.error('Error sending email:', error);
      // Handle the error scenario here
      alert("Can not send email");
    });

  };
  

  const getAttendedSessions = (employee) => {
    return employee.attendedList;
  };

  const getNotAttendedSessions = (employee) => {
    return employee.pendingList;
  };

  const filteredEmployees = employees.filter((employee) =>
    employee.employeeName.toLowerCase().includes(searchName.toLowerCase())
  );

  return (
    <div className='main_container'>
      <div className='serchBox'>
        <input
          type="search"
          placeholder="Search by Name"
          onChange={(e) => {
            setSearchName(e.target.value);
            setSelectedEmployee(null);
            setEmployeeSelected(null);
            setNameSelected(false); // Reset nameSelected when the search box value changes
          }}
          value={searchName}
        />
        {searchName !== '' && !nameSelected && ( // Only render search results when nameSelected is false
          <div className='searchResult'>
            {filteredEmployees.map((item) => (
              <p key={item.id} onClick={() => handleEmployeeSelect(item)}>
                {item.employeeName}
              </p>
            ))}
          </div>
        )}
      </div>
      {employeeSelected !== null && (
        <div className='table_container'>
          <div className='attendeList'>
            <h3>Attended Sessions</h3>
            {employeeSelected?.attendedList?.map((item, index) => (
              <p key={index}>{item}</p>
            ))}
          </div>
          <div className='attendeList'>
            <h3>Pending Sessions</h3>
            {employeeSelected?.pendingList?.map((item, index) => (
              <p key={index}>{item}</p>
            ))}
          </div>
        </div>
      )}
      <div className='sendMail'>
        <div className='cc_container'>
        <input type='checkbox' checked={cc} onClick={()=>setCC(!cc)} ></input><p>cc</p></div>
        <div className='messageBox'><p>Enter Message</p><input type='text' value={message} onChange={(e)=>setMessage(e.target.value)}></input></div>
        <button onClick={sendEmail}>Send Email</button>
      </div>
    </div>
  );
}

export default EmployeeTable;
