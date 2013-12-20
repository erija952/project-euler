#!/usr/bin/ruby

$sum = 0
$f1 = 0
$f2 = 1

begin
  $tmp = $f1
  $f1 = $f2
  $f2 = $tmp + $f1
  if $f2.modulo(2).zero?
    $sum = $sum + $f2 
  end
end while $sum < 4000000

puts "Sum is #$sum"

