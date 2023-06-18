pragma solidity >=0.5.0 <0.8.0;
// IMPORTANT: COMPILER => 0.6.0

library SafeMath{
    // Subtraction
        function sub(uint256 a, uint256 b) internal pure returns (uint256) {
        uint256 c = a - b;
        assert(b <= a);
        return c;
        }

    // Addition
        function add(uint256 a, uint256 b) internal pure returns (uint256) {
        uint256 c = a + b;
        assert(c >= a);
        return c;
        }

    // Multiplication
        function mul(uint256 a, uint256 b) internal pure returns (uint256) {
        if (a == 0) {
        return 0;
        }
        uint256 c = a * b;
        require(c / a == b, "SafeMath: multiplication overflow");
        return c;
        }
}

//Interface token ERC
interface IERC20{
    //Total number of token supply 
    //Once this limit is reached, the contract will refuse to create more tokens.
    function totalsupply()external view returns (uint256);

    //Returns the number of tokens from an address
    //This function is used for the contract to return the number of tokens that a portfolio has
    function balanceOf(address account)external view returns (uint256);

    //A user has enough tokens (and returns the number) 
    //Function that checks if a user has enough tokens to send them to another user
    function allowance(address owner, address spender)external view returns (uint256);

    //Initial supply tokens to a user
    //The function that allows to obtain a number of tokens from the initial supply and give them to a user
    function transfer(address recipient, uint256 amount) external returns (bool);

    //Function that checks if the contract can send a number of tokens to a user 
    //taking into account the total supply of tokens
    function approve(address spender, uint256 amount) external returns (bool);

    //This function enable the transfer of token between users
    function transferFrom(address sender, address recipient, uint256 amount) external returns (bool);

    //Event number 1: notifies when a quantity of tokens passes from a source to a destination
    event Transfer(address indexed from, address indexed to, uint256 value);

    //Event number 2: notifies the approval of the allowance function
    event Approval(address indexed owner, address indexed spender, uint256 value);

}

//Implementation of ERC20 token functions
contract ERC20Initial is IERC20{
    string public constant name = "PANGEA GAIA";
    string public constant symbol = "GAIA";
    uint public constant decimals= 2;
    event Transfer(address indexed from, address indexed to, uint256 tokens);
    event Approval(address indexed owner, address indexed spender, uint256 tokens);
    using SafeMath for uint256;

    //Indicates that each address will correspond to a certain amount of tokens
    mapping(address=>uint) balances;

    //Indicates that each address corresponds to a set of addresses with a quantity in each of them
    //It serves to see that although the tokens may have been mined by a single person
    //can be distributed among diferents users and so on
    mapping (address => mapping (address => uint)) allowed;
    uint256 totalSupply_;

    //It also defines that the constructor will be the only one that can determine the total amount of tokens
    constructor (uint256 initialSupply) public{
        totalSupply_ = initialSupply;
        balances[msg.sender]=totalSupply_;
    }

    //***** 
    //Implementation of the logic of functions
    function totalsupply() public override view returns (uint256){
    return totalSupply_;
    }

    function increaseTotalSupply(uint newTokensAmount) public {
        totalSupply_+=newTokensAmount;
        balances[msg.sender]+= newTokensAmount;
    }

    function balanceOf(address tokenOwner) public override view returns (uint256){
    return balances[tokenOwner];
    }

    function allowance(address owner, address delegate) public override view returns (uint256){
        return allowed[owner][delegate];
    }

    function transfer(address recipient, uint256 numTokens) public override returns (bool){
        require(numTokens <=balances[msg.sender]);
        balances[msg.sender]=balances[msg.sender]. sub(numTokens);
        balances[recipient]=balances[recipient].add(numTokens);
        emit Transfer(msg.sender, recipient, numTokens);
        return true;
    }

    function approve(address delegate, uint256 numTokens) public override returns (bool){
        allowed[msg.sender][delegate]=numTokens;
        emit Approval(msg.sender, delegate, numTokens);
        return true;
    }
    
    function transferFrom(address owner, address buyer, uint256 numTokens) public override returns (bool){
        require(numTokens <= balances[owner]);
        require(numTokens <= allowed[owner][msg.sender]);
        balances[owner]=balances[owner].sub(numTokens);
        allowed[owner][msg.sender]=allowed[owner][msg.sender].sub(numTokens);
        balances[buyer]=balances[buyer].add(numTokens);
        emit Transfer (owner, buyer, numTokens);
        return true;
    }

}