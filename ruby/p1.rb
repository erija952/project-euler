#!/usr/bin/ruby

array = Array(0..999)
sum = 0
for index in 0 ... array.size
  if array[index].modulo(3).zero? or array[index].modulo(5).zero?
    sum = sum + array[index]
  end
end
puts "Sum is #{sum}"

