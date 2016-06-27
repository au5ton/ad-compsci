class ArrayFunHouse
    def self.get_sum(array, start, stop)
        sum = 0.0
        if array.length > 0 then
            for i in start..stop
                sum += array[i]
            end
        end
        return sum
    end
    def self.get_count(array, val)
        count = 0
        if array.length > 0
            array.each do |i|
                if i == val
                    count += 1
                end
            end
        end
        return count
    end
    def self.remove_val(array,val)
        arr = array.clone
        arr.delete_at(arr.find_index(val))
        return arr
    end
end

if __FILE__ == $0
    one = [4,10,0,1,7,6,5,3,2,9]
    puts "#{one}"
    puts "sum of spots 3-6 = #{ArrayFunHouse.get_sum(one,3,6)}"
    puts "sum of spots 2-9 = #{ArrayFunHouse.get_sum(one,2,9)}"
    puts "# of 4s = #{ArrayFunHouse.get_count(one,4)}"
    puts "# of 7s = #{ArrayFunHouse.get_count(one,7)}"
    puts "before removing all 7s #{one}"
    one = ArrayFunHouse.remove_val(one,7)
    puts "after removing all 7s #{one}"
    puts "# of 7s = #{ArrayFunHouse.get_count(one,7)}"
    puts "********************************************"

    two = [4,2,3,4,6,7,8,9,0,10,0,1,7,6,5,3,2,9,9,8,7]
    puts "#{two}"
    puts "sum of spots 20-21 = #{ArrayFunHouse.get_sum(two,20,21)}"
    puts "sum of spots 8-11 = #{ArrayFunHouse.get_sum(two,8,11)}"
    puts "# of 2s = #{ArrayFunHouse.get_count(two,2)}"
    puts "# of 9s = #{ArrayFunHouse.get_count(two,9)}"
    puts "before removing all 9s #{two}"
    two = ArrayFunHouse.remove_val(two,9)
    puts "after removing all 9s #{two}"
    puts "# of 7s = #{ArrayFunHouse.get_count(two,9)}"
end
