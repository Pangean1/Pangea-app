pragma solidity ^0.8.0;

interface ERC20 {
    function sendToken(address sender, address recipient, uint amount) external returns (bool);
    event Transfer(address indexed from, address indexed to, uint value);
}

contract SendGAIA {
    ERC20 public token;

    constructor(address _token) {
        token = ERC20(_token);
    }

    function sendTokenGAIA(address recipient, uint amount) public {
        require(token.sendToken(msg.sender, recipient, amount), "Send failed");
    }
}