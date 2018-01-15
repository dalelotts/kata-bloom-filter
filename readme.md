# Bloom-filter Kata

From http://codekata.com/kata/kata05-bloom-filters/

Bloom filters are a statistical way of testing for membership in a set. They greatly reduce the amount of storage you 
need to represent the set, but at a price: they’ll sometimes report that something is in the set when it isn’t 
(but it’ll never do the opposite; if the filter says that the set doesn’t contain your object, you know that it doesn’t).

## Java 9 and JUnit 5

I decided to use Java for this Kata because I wanted to try out Java 9 and JUnit 5. 
I also suspect that the `.hashCode()` method on Object will be a "good enough" hash algorithm for this Kata 

Finally, I plan to [simulate N hash functions](http://willwhim.wpengine.com/2011/09/03/producing-n-hash-functions-by-hashing-only-once/) 

## Running the tests

`git clone https://github.com/dalelotts/kata-bloom-filter`
`cd kata-bloom-filter`
`gradlew test`

## Behavior

- Passing `null` to the `.exists` method will throw an Illegal Argument Exception.

## Areas for improvement

This was my first attempt at this kata so this code mostly represents me getting a feel for the problem space. 
This is a partial list of areas for improvement for this code.

- Add tests that drive implementation of:
    - computed initial size of BitSet
    - multiple hash passes (by returning false positive) 
    - applying a modulo on the hash values to limit space utilization
- Replace `null` and `empty` string checks with annotations and use annotation pre-processors to inject the code at compile time.
- Replace BitSet with some other data structure allowing `long` values for keys.
- Replace Murmur hash with SipHash to have fewer collisions and prevent HashDOS attacks. 

