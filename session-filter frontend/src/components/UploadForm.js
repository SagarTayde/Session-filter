import React from 'react';
import './UploadForm.css';

function UploadForm({ handleFileChange, handleFileUpload }) {
  return (
    <div className="uploadContainer">
      <input type="file" className="form-control file-input" accept=".xlsx, .xls" onChange={handleFileChange} />
      <button className="btn btn-primary upload-button" onClick={handleFileUpload}>Upload File</button>
    </div>
  );
}

export default UploadForm;
