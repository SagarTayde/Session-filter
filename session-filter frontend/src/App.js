import React, { useState } from 'react';
import './App.css';
import Header from './components/Header';
import UploadForm from './components/UploadForm';
import EmployeeTable from './components/EmployeeTable';

function App() {
  const [selectedFile, setSelectedFile] = useState(null);
  const [employees, setEmployees] = useState([]);
  const [selectAll, setSelectAll] = useState(false);
  const [selectedEmployees, setSelectedEmployees] = useState([]);

  const handleFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleFileUpload = async () => {
    if (!selectedFile) {
      alert('Please select a file to upload.');
      return;
    }

    const formData = new FormData();
    formData.append('file', selectedFile);

    try {
      const response = await fetch('http://localhost:8084/employees', {
        method: 'POST',
        body: formData,
      });

      if (response.ok) {
        const data = await response.json();
        setEmployees(data);
        alert('File uploaded Successfully');
      } else {
        alert('Error uploading the file.');
      }
    } catch (error) {
      alert('Error uploading the file.');
    }
  };

  console.log(employees);

  const handleCheckboxChange = (event, employee) => {
    if (event.target.checked) {
      setSelectedEmployees([...selectedEmployees, employee]);
    } else {
      setSelectedEmployees(selectedEmployees.filter(selected => selected !== employee));
    }
  };

  const handleSelectAllChange = (event) => {
    setSelectAll(event.target.checked);
    if (event.target.checked) {
      setSelectedEmployees(employees);
    } else {
      setSelectedEmployees([]);
    }
  };

  return (
    <div className="App">
      <Header />
      <UploadForm handleFileChange={handleFileChange} handleFileUpload={handleFileUpload} />
      <EmployeeTable
        employees={employees}
        selectedEmployees={selectedEmployees}
        handleCheckboxChange={handleCheckboxChange}
        handleSelectAllChange={handleSelectAllChange}
        selectAll={selectAll}
      />
    </div>
  );
}

export default App;
