import React,{useState} from "react";
import './CustomerList.css';

const CustomerList = () => {
    const [inputValue, setInputValue] = useState('');
    const [customerList, setCustomerList] = useState([]);

    const handleInputChange = (e) => {
        setInputValue(e.target.value);
    };

    const handleAddCustomer = () => {
        if(inputValue === '') return;

        setCustomerList([...customerList, inputValue]);
        setInputValue('');
    };
    return (
        <div className="customer-list-container">
            <h2>Customer List</h2>
            <div className="input-container">
                <input
                type="text"
                value={inputValue}
                onChange={handleInputChange}
                placeholder="Enter name"
                data-testid="app-input"
                />
                <button onClick={handleAddCustomer} data-testid="submit-button">
                    Add Customer
                </button>
            </div>
            {customerList.length > 0 && (
                <ul data-testid="customer-list" className="customer-list">
                    {customerList.map((customer, index) => (
                        <li key={index} data-testid={`list-item${index}`}>
                            {customer}
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};


export default CustomerList;