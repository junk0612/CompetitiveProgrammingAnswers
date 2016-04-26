until (n = gets.to_i).zero?
  array = n.times.map {gets.to_i}
  puts (array.reduce {|sum, n| sum + n} - array.max - array.min) / (n - 2)
end
