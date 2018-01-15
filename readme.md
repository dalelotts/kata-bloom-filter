# Bloom-filter Kata

From http://codekata.com/kata/kata05-bloom-filters/

Bloom filters are a statistical way of testing for membership in a set. They greatly reduce the amount of storage you 
need to represent the set, but at a price: they’ll sometimes report that something is in the set when it isn’t 
(but it’ll never do the opposite; if the filter says that the set does not contain your object, you know that it does not).

## Summary

I learned a lot about Bloom Filters, non-cryptographic hashing algorithms, Java 9, and JUnit 5 during this implementation. 

When I read the problem, I did not know where to start. How will I go about selecting the _right_ hashing algorithm? 
How will I test for _false positives_ without knowing how the selected hash algorithms will collide.

TDD to the rescue (as Usual)! None of that really matters. I can trust that writing small tests that drive the 
implementation forward one _baby step_ at a time will ultimately lead to a complete implementation and I don't need to 
know everything in advance.

This implementation is (currently) far from complete and I will revisit this Kata again in the future.

## Running the tests

`git clone https://github.com/dalelotts/kata-bloom-filter`
`cd kata-bloom-filter`
`gradlew test`

## Areas for improvement

This was my first attempt at this kata so this code mostly represents me getting a feel for the problem space. 
This is a partial list of areas for improvement for this code.

- Determine what needs to change to get output _while_ running `gradlew test`. 
- Add tests that drive implementation of:
    - Improve speed. Clearly the implementation is incomplete because the brute-force tests using 38882 words takes too long. 
    - computed initial size of BitSet
    - multiple hash functions (by returning false positive) See 
      [simulate N hash functions](http://willwhim.wpengine.com/2011/09/03/producing-n-hash-functions-by-hashing-only-once/) 
    - applying a modulo on the hash values to limit space utilization
- Replace `null` and `empty` string checks with annotations and use annotation pre-processors to inject the code at compile time.
- Replace BitSet with some other data structure allowing `long` values for keys.
- Replace Murmur hash with SipHash to have fewer collisions and prevent HashDOS attacks. 

