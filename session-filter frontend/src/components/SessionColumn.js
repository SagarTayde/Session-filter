import React from 'react';

function SessionColumn({ sessionsAttended, sessionsNotAttended }) {
  return (
    <td>
      <strong>Sessions Attended:</strong> {sessionsAttended.join(', ')}
      <br />
      <strong>Sessions Not Attended:</strong> {sessionsNotAttended.join(', ')}
    </td>
  );
}

export default SessionColumn;
