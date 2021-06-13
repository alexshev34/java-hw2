import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HW2 {
	
	//Задача 1
	public static <T> Collection<T> removeDublicates(Collection<T> collection){
		return new HashSet<>(collection);
	}
	//Задача 2
	public static <K, V> Map<V, Collection<K>> inverse(Map<? extends K, ? extends V> map){
		Map<V, Collection<K>> output = new HashMap<>();

		Set<K> keys = (Set<K>) map.keySet();
		
		for(K key : keys){
		V value = map.get(key);
		output.compute(value, (v, ks) -> {
		if(ks == null){
		ks = new HashSet<>();
		}
		ks.add(key);
		return ks;
		});
		}
		return output;
	}
	// Задача 3
	public static void winner() {
		
		String[] arr = new String[] {"Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"}; //входные данные
		
		String[] t;
		String[] winner = null; // наш дальнейший победитель
		
		ArrayList<Integer> number = new ArrayList<Integer>(); // возьмем под отдельный список очков так как они у нас всегда целые укажем тип integer
		//занесем все очки в список 
		for(int i = 0; i < arr.length; i++) {
			t = arr[i].split(" ");
			number.add(Integer.valueOf(t[t.length-1]));
			
		}
		int maxIndex = Collections.max(number); //возьмем максимальное число из списка
		
		//найдем бервого игрока с набравшим максимальное число очков и слоем цикл
		for(int i = 0; i < number.size(); i++) {
			if(number.get(i) == maxIndex) {
				winner = arr[i].split(" ");
				break;
			}
		}
		System.out.println("Победитель данной игры " + winner[0]);
	}

	public static void main(String[] args) {
		
		winner();
		}
}
