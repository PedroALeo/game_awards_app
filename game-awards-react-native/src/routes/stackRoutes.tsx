import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import { VoteScreen } from '../screens/VoteScreen';
import { WinnerScreen } from '../screens/WinnerScreen';
import {MaterialCommunityIcons} from '@expo/vector-icons'

const { Screen, Navigator} = createBottomTabNavigator();

export function StackRoutes(){
    return(
        <Navigator
            screenOptions={({route}) => ({
                headerShown: true,
                tabBarStyle: {
                    height:70,
                    paddingHorizontal:2,
                    paddingTop: 0,
                    backgroundColor: 'rgba(34,36,40,1)',
                    position: 'absolute',
                    borderTopWidth: 0,
                }
            })}
        >
            <Screen
                name='Votes'
                component={VoteScreen}
                options={{
                    tabBarLabel: 'Votar',
                    tabBarActiveTintColor: 'white',
                    tabBarIcon: ({color, size}) => (
                        <MaterialCommunityIcons
                            name="home"
                            color="#6DFF60"
                            size={size}
                        />
                    ),
                }}
            />

            <Screen
                name= 'Winner'
                component={WinnerScreen}
                options={{
                    tabBarLabel: 'Result',
                    tabBarActiveTintColor: 'white',
                    tabBarIcon: ({color, size}) => (
                        <MaterialCommunityIcons
                            name="trophy"
                            color="#6DFF60"
                            size={size}
                        />
                    ),
                }}
             />

        </Navigator>
    )
}