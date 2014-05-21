#! ruby -Ku
class NextMayor
	def main
		while(true)
			str=gets()
			strs = str.split()
			n=strs[0].to_i()
			p=strs[1].to_i()
			if(n==0&&p==0)
				break
			end
			array=Array.new(n,0)
			s=p
			pointer=0
			while(true)
				if s!=0
					s=s-1
					array[pointer]=array[pointer]+1
				end
				if s==0
					s=array[pointer]
					array[pointer]=0
				end
				if array[pointer]==p
					break
				end
				pointer=pointer+1
				if(pointer=n)
					pointer = pointer - n
				end
			end
			puts(pointer)
		end
	end
end

NextMayor.new.main