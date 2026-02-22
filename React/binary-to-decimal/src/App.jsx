import React, { useEffect, useState } from "react";

const App = () => {
  const [binary, setBinary] = useState("");
  const [decimal, setDecimal] = useState(null);
  const [error, setError] = useState("");

  // Convert binary to decimal
  const convertToDecimal = (binaryStr) => {
    if (binaryStr === "") return null;
    return parseInt(binaryStr, 2); // base 2 conversion
  };

  // Handle input change
  const handleInputChange = (e) => {
    const value = e.target.value;

    if (value.length > 8) {
      setError("Binary input cannot exceed 8 digits");
      return;
    }

    if (!/^[01]*$/.test(value)) {
      setError("User input must be 0 or 1");
      return;
    }

    setError("");
    setBinary(value);
  };

  useEffect(() => {
    if (binary === "") {
      setDecimal(null);
      return;
    }
    const result = convertToDecimal(binary);
    setDecimal(result);
  }, [binary]);

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>Binary to Decimal Converter</h2>
      <input
        type="text"
        value={binary}
        onChange={handleInputChange}
        placeholder="Enter binary (0-1)"
      />
      <p>Decimal: {decimal !== null ? decimal : "-"}</p>
      {error && <p style={{ color: "red" }}>{error}</p>}
    </div>
  );
};

export default App;
