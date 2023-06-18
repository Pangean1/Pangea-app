pragma solidity ^0.8.0;

import "@openzeppelin/contracts/token/ERC721/ERC721.sol";

// The unique identifier for each parcel NFT
contract parcel is ERC721 { 
uint256 public parcelId;

// The name of the parcel NFT
string public name;

// The symbol of the parcel NFT
string public symbol;

// The address of the owner of the parcel NFT
address public owner;

// The price of the parcel NFT
uint256 public price;

// The IPFS hash of the parcel image
string public imageHash;

// The IPFS hash of the parcel metadata
string public metadataHash;

constructor(string memory _name, string memory _symbol, string memory _imageHash, string memory _metadataHash, uint256 _price) ERC721(_name, _symbol) {
    name = _name;
    symbol = _symbol;
    imageHash = _imageHash;
    metadataHash = _metadataHash;
    owner = msg.sender;
    price = _price;
}

// Get the current owner of the parcel
function getOwner() public view returns(address) {
    return owner;
}

// Get the current price of the parcel
function getPrice() public view returns(uint256) {
    return price;
}

// Set the new price of the parcel
function setPrice(uint256 _price) public {
    require(msg.sender == owner, "Only the owner can set the price of the parcel");
    price = _price;
}

}


