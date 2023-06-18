pragma solidity ^0.8.0;

contract SendCrypto {
    function send(address payable recipient, uint amount) public payable {
        require(msg.sender.balance >= amount, "Insufficient balance.");
        recipient.transfer(amount);
    }
}
