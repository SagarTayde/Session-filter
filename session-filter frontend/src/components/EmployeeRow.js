import React from 'react';
import SessionColumn from './SessionColumn'; // Import the SessionColumn component

function EmployeeRow({ employee, selectedEmployees, handleCheckboxChange }) {
  const sessionsAttended = employee.sessions.filter((session) => session.attended);
  const sessionsNotAttended = employee.sessions.filter((session) => !session.attended);

  return (
    <tr>
      <td>
        <input
          type="checkbox"
          className="employee-checkbox"
          checked={selectedEmployees.includes(employee)}
          onChange={(e) => handleCheckboxChange(e, employee)}
        />
      </td>
      <td>{employee.employeeId}</td>
      <td>{employee.employeeName}</td>
      <td>{employee.employeeEmailId}</td>
      <td>{employee.reportingName}</td>
      <td>{employee.reportingEmailId}</td>
      <SessionColumn
        sessionsAttended={sessionsAttended.map((session) => session.name)}
        sessionsNotAttended={sessionsNotAttended.map((session) => session.name)}
      />
    </tr>
  );
}

export default EmployeeRow;
